package com.example.Crawler.crawler;
import com.example.Crawler.dto.QuestionListDTO;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.fasterxml.jackson.core.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashSet;

public class JsonWriteRead {

    private static final String FILE_PATH = "/Users/brutalcoder/Music/CrawlerText/src/main/java/com/example/CrawlerText/Assets/questions.json";
    JSONArray jsonArray = new JSONArray();
    public void  WriteToJSON(HashSet<QuestionListDTO> questionListDTO){
        try {
            File file = new File(FILE_PATH);
            FileWriter fr = new FileWriter(file, true);
                JSONObject responseDetailsJson = new JSONObject();
                for(QuestionListDTO qdto: questionListDTO){
                    JSONObject formDetailsJson = new JSONObject();
                    formDetailsJson.put("questionId", qdto.getQuestionHashCode());
                    formDetailsJson.put("questionName", qdto.getQuestionName());
                    formDetailsJson.put("questionContent",qdto.getQuestionContent());
                    formDetailsJson.put("questionType", qdto.getQuestionType());
                    formDetailsJson.put("answerType", qdto.getAnswerType());
                    formDetailsJson.put("questionDifficulty", qdto.getQuestionDifficulty());
                    formDetailsJson.put("questionCategory", qdto.getQuestionCategory());
                    formDetailsJson.put("answerOptions", qdto.getAnswerOptions());
                    formDetailsJson.put("correctAnswer", qdto.getCorrectAnswers());
                    jsonArray.put(formDetailsJson);
                }
            fr.write(jsonArray.toString());
            System.out.println(jsonArray);
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ReadFromJSON(){

        JSONParser jsonParser = new JSONParser();
        try {
            File file = new File(FILE_PATH);
            FileReader fileReader = new FileReader(file);
            Object obj = jsonParser.parse(new FileReader(file));

        }
        catch (Exception e){

        }
    }
}
