/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Crawler.crawler;
import java.io.File;
//import web.crawler.Spider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;
/**
 *
 * @author prate
 */
public class SpiderTest
{
    //public static String url="https://www.indiabix.com/logical-reasoning/number-series/";
    private static final String FILE_PATH = "/Users/brutalcoder/Movies/CrawlerText/src/Assets/ExamsBookLinks.txt";
    private static int flag = 1;
    public static void main(String[] args)
    {
//        Spider spider=new Spider();
//        CrawlerText crawler = new CrawlerText();
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                url = line;
//                //spider.search(url,flag);
//                crawler.crawl(url);
//                line = bufferedReader.readLine();
//                flag++;
//            }
//
//            crawler.crawl(url);
//            bufferedReader.close();
//            //spider.search(line);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
        CrawlingVideos crawlingVideos = new CrawlingVideos();
        crawlingVideos.crawl();
    }
}