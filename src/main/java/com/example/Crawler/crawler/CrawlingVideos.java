package com.example.Crawler.crawler;

import com.example.Crawler.dto.QuestionListDTO;

import java.util.HashSet;

public class CrawlingVideos {

    public HashSet<QuestionListDTO> questionListDTO = new HashSet<>();
    public void crawl(){
        JsonWriteRead jsonWriteRead = new JsonWriteRead();
        String question[] = {"Which movie is this from?", "Which movie is this from?"};
        String questionContent[] = {"https://giphy.com/gifs/xUySTRb9wlX3zSANWg/html5", "https://giphy.com/gifs/l1IY6ZbiqOubhFCes/html5"};
        String answerOptions[] = {"Kuch Kuch hota hain ; Kabhi Khushi Kabhi Gum ; Karan Arjun", "Bunty aur Bubly; Delhi 6; maasoom"};
        String answer[] = {"B", "A"};
        for(int integerLoop = 0;integerLoop<question.length;integerLoop++) {
            QuestionListDTO questionListDTO1 = new QuestionListDTO();
            questionListDTO1.setQuestionName(question[integerLoop]);
            questionListDTO1.setQuestionHashCode(((String) (question[integerLoop] + questionContent[integerLoop])).hashCode());
            questionListDTO1.setQuestionCategory("Movies");
            questionListDTO1.setAnswerOptions(answerOptions[integerLoop]);
            questionListDTO1.setAnswerType("Single");
            questionListDTO1.setCorrectAnswers(answer[integerLoop]);
            questionListDTO1.setQuestionDifficulty("Average");
            questionListDTO1.setQuestionType("Video");
            questionListDTO1.setQuestionContent(questionContent[integerLoop]);
            questionListDTO.add(questionListDTO1);
            //jsonWriteRead.WriteToJSON(questionListDTO);
        }
        jsonWriteRead.WriteToJSON(questionListDTO);
    }
}
