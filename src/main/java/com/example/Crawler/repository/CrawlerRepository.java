package com.example.Crawler.repository;

import com.example.Crawler.crawler.Crawling;
import com.example.Crawler.dto.QuestionListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CrawlerRepository extends MongoRepository<QuestionListDTO, String> {

}
