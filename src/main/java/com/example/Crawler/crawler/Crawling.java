package com.example.Crawler.crawler;

import com.example.Crawler.dto.QuestionListDTO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;

public class Crawling {
    public HashSet<String> hashSet = new HashSet<String>();

    public HashSet<QuestionListDTO> questionListDTOList = new HashSet<>();
    public HashSet<String> getHashSet() {
        return hashSet;
    }

    public void setHashSet(HashSet<String> hashSet) {
        this.hashSet = hashSet;
    }

    public void Crawl(String url) {


        try {

            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if (connection.response().statusCode() == 200) {

                Elements links = document.select("a[href]");

                Element post = document.select("div[class='question text-center panel panel-primary']").first();

                Element question = post.select("h3[class='text-primary']").first();
                Element questionContent = post.selectFirst("source[src]");
                String questionContentString[] = questionContent.toString().split("\\\"");
                Elements options = post.select("button[class='answer-button btn btn-default btn-lg answerbtn']");
                String answer = "";

                QuestionListDTO questionListDTO = new QuestionListDTO();
                System.out.println("Question: " + question.ownText());
                questionListDTO.setQuestionName(question.ownText());
                //System.out.println("ImageUrl"+questionContent);

                System.out.println("AudioURL" + questionContentString[1]);
                //questionListDTO.setQuestionType(questionContentString[1]);

                System.out.println("Options");

                for (Element element1 : options) {
                    System.out.println(element1.text());
                    if (((String) element1.attr("onclick")).contains("\'Correct\'")) {
                        answer = element1.text();
                    }
                }

                questionListDTO.setAnswerOptions(options.get(0).text() + ";" + options.get(1).text() + ";" + options.get(2).text());
                System.out.println("answer: " + answer);
                questionListDTO.setCorrectAnswers(answer);
                questionListDTO.setQuestionContent(questionContentString[1]);
                System.out.println(questionListDTO.getQuestionContent() + " ImageURL");
                //System.out.println(questionListDTO.getQuestionContent());
                questionListDTO.setQuestionType("Audio");
                questionListDTO.setAnswerType("Single");
                questionListDTO.setQuestionCategory("Music");
                questionListDTO.setQuestionDifficulty("Average");
                questionListDTO.setQuestionHashCode((questionContent.toString() + question.toString()).hashCode());
                questionListDTOList.add(questionListDTO);

                JsonWriteRead jsonWriteRead = new JsonWriteRead();
                jsonWriteRead.WriteToJSON(questionListDTOList);
            }


        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "Exception");

        }


    }

    public Elements CrawlLinks(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();
            Elements links = new Elements();
            if (connection.response().statusCode() == 200) {

                Element pages = document.select("#right-panel > div.pagination > ul").first();
                links = pages.select("a[href]");
                System.out.println(links);

            }
            return links;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
