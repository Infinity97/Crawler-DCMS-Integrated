package com.example.Crawler.crawler;

import com.example.Crawler.dto.QuestionListDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class CrawlerText {
    public static HashSet<String> set = new HashSet();
    String header = "https://www.indiabix.com";
    public static HashSet<QuestionListDTO> questionListDTO = new HashSet<>();
    public static int i =0;
    public static int integer =0;
    public void crawling(String url) {
        Document doc = null;
        try {

            doc = (Document) Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element titleContainer = doc.selectFirst("title");
        String title[] = titleContainer.text().split("-");
        Elements containers = doc.select("div.bix-div-container"); // a with href
        for (Element element : containers) {
            i++;
            Element question = element.selectFirst("p");
            Elements answerTag = element.select("[type=\"hidden\"]");
            String answer = answerTag.val();
            Elements options = element.select("[width=\"99%\"]");
            String answerOptions = "";
            for (Element option : options) {
                answerOptions = answerOptions + ((String) option.ownText()) + ";";
            }
            QuestionListDTO questionListDTO1 = new QuestionListDTO();
            questionListDTO1.setQuestionName(question.ownText());
            questionListDTO1.setQuestionHashCode(question.ownText().hashCode());
            questionListDTO1.setQuestionCategory(title[0]);
            questionListDTO1.setAnswerOptions(answerOptions);
            questionListDTO1.setAnswerType("Single");
            questionListDTO1.setCorrectAnswers(answer);
            questionListDTO1.setQuestionDifficulty("Easy");
            questionListDTO1.setQuestionType("Text");
            questionListDTO1.setQuestionContent(" ");
            questionListDTO.add(questionListDTO1);
        }
        System.out.println("Iterations are: -  " + i);
    }
    public void crawl(String url) {
        //CSVReaderWriter csvReaderWriter = new CSVReaderWriter();
        JsonWriteRead jsonWriteRead = new JsonWriteRead();
        Document doc = null;
        CrawlerText obj = new CrawlerText();
        try {
            doc = (Document) Jsoup.connect(url).get();
            Elements linksContainer = doc.select("body > div.whole-page > div > div.main-left > div.mx-pager-container > p");
            Elements links = linksContainer.select("a[href]");
            for (Element link : links) {
                String href = header + ((String) link.attr("href"));
                set.add(href);
            }
            for (String i : set) {
                System.out.println(i);
                obj.crawling(i);
            }
            int length = questionListDTO.size();
            System.out.println("Length of the array is :- " + length);
            for(QuestionListDTO ques: questionListDTO){
                System.out.println(ques.toString());
            }
            jsonWriteRead.WriteToJSON(questionListDTO);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}