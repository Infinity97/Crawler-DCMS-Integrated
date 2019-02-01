package com.example.Crawler.crawler;

import java.util.*;
import java.io.IOException;

import com.example.Crawler.dto.QuestionListDTO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private Document htmlDocument;
    Set<String> linksSet = new HashSet<>();
    List<QuestionListDTO> questionListDTO = new ArrayList<>();

    public void getLinks(String url) {

    }

    public void display() {
        System.out.println();
    }

    public void search(String url, int flag) {
        int i = 1;
        System.out.println("********YOU ARE IN SEARCH******");
        List<String> questions = new ArrayList<String>();
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            if (connection.response().statusCode() == 200) {
                //System.out.println("Recieved Webpage from :" + url);
            }
            Elements titleString = htmlDocument.select("title");

            String title[] = titleString.text().split("\\s");
            Elements paragraphtag = htmlDocument.select("div.shortcode-content");
            Elements questionsTag = htmlDocument.select("div.shortcode-content>strong");


            /* Questions */
            for (Element elements : paragraphtag) {
                int getNextFour = 1;
                String text = elements.ownText();
                QuestionListDTO questionListDTO1 = new QuestionListDTO();
                int index = text.indexOf("?");
                String texts[] = text.split("\\[A]");
                for (String something : texts) {
                    System.out.println(something);
                }
                if (index != -1) {
                    System.out.println(index);
                    String first = elements.nextElementSibling().ownText();
                    String second = elements.nextElementSibling().nextElementSibling().ownText();
                    String third = elements.nextElementSibling().nextElementSibling().nextElementSibling().ownText();
                    String fourth = elements.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().ownText();
                    String answeroptions = first + " ; " + second + " ; " + third + " ; " + fourth;
                    String questionName = text.substring(0, index + 1);
                    questionListDTO1.setQuestionName(questionName.substring(1));
                    questionListDTO1.setQuestionHashCode(questionName.hashCode());
                    questionListDTO1.setAnswerOptions(answeroptions);
                    questionListDTO1.setQuestionCategory(title[0] + title[1]);
                    questionListDTO1.setAnswerType("Single");
                    questionListDTO1.setQuestionType("Text");
                    questionListDTO1.setQuestionDifficulty("Easy");
                    questionListDTO.add(questionListDTO1);
                }
            }
            for (Element textt : questionsTag) {
                System.out.println(textt.ownText());
            }
            /* Correct Answers */
            for (QuestionListDTO qdto : questionListDTO) {
                String classTag = "." + i + "-content";
                Elements answer = htmlDocument.select(classTag);
                String correctAnswer = answer.text();
                qdto.setCorrectAnswers(correctAnswer.substring(0));
                i++;
            }
            /*Displaying the entire list*/
            for (QuestionListDTO ques : questionListDTO) {
                System.out.println(ques.toString());
            }
//            CSVReaderWriter csvReaderWriter = new CSVReaderWriter();
//            csvReaderWriter.writeToFile(questionListDTO);
        } catch (IOException ioe) {
            System.out.println("Error in out HTTP request " + ioe);
        }
    }

    public void newSearch(String url, int flag) {

         int i=1;
        System.out.println("********YOU ARE IN SEARCH******");
        List<String> questions = new ArrayList<String>();
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            if (connection.response().statusCode() == 200) {
                //System.out.println("Recieved Webpage from :" + url);
            }
            Elements titleString = htmlDocument.select("title");

            String title[] = titleString.text().split("\\s");
            Elements paragraphtag = htmlDocument.select("div.shortcode-content");
            Elements questionsTag = htmlDocument.select("div.shortcode-content>strong");

            for (Element elements : paragraphtag) {
                String text = elements.ownText();
                QuestionListDTO questionListDTO1 = new QuestionListDTO();
                //int index = text.indexOf("1");
                String texts[] = text.split("\\[A]");
                for (String something : texts) {
                    // System.out.println(something);
                    questionListDTO1.setAnswerOptions("[A] " + something);
                }
                String classTag = "." + i + "-content";
                Elements answer = htmlDocument.select(classTag);
                String correctAnswer = answer.text();
                questionListDTO1.setCorrectAnswers(correctAnswer.substring(0));
                //System.out.println(classTag + "      " + correctAnswer);
                i++;
            }


            /*Displaying the entire list*/
            for (Element textt : questionsTag) {
                //System.out.println(textt.ownText());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
