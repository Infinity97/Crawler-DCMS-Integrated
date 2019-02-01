package com.example.Crawler.services;

import com.example.Crawler.dto.QuestionListDTO;

import java.util.List;

public interface CrawlerServices {

    void create(QuestionListDTO emloyee);

    List<QuestionListDTO> read();

    void update(QuestionListDTO questionId);

    void delete(String questionId);
    
}
