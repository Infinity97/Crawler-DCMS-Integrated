package com.example.Crawler.crawler;

import java.io.FileWriter;
import java.io.File;
import java.util.List;

import com.example.Crawler.dto.QuestionListDTO;


public class CSVReaderWriter {

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";
    public void writeToFile(List<QuestionListDTO> questionListDTO) {
        final String FILE_PATH = "/Users/brutalcoder/Movies/CrawlerText/src/Assets/questions.csv";
        try {

            File file = new File(FILE_PATH);
            FileWriter fr = new FileWriter(file, true);
            for(QuestionListDTO qdto: questionListDTO){

                fr.append(NEW_LINE_SEPARATOR);
                fr.append(qdto.getQuestionName());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getQuestionContent());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getQuestionType());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getAnswerType());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getQuestionDifficulty());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getQuestionCategory());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getAnswerOptions());
                fr.append(COMMA_DELIMITER);
                fr.append(qdto.getCorrectAnswers());
            }
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
