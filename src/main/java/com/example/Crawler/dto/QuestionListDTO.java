package com.example.Crawler.dto;

import java.util.Objects;
public class QuestionListDTO {

    private long  questionHashCode;
    private String questionName;
    private String questionContent;
    private String questionCategory;
    private String questionType;
    private String answerType;
    private String questionDifficulty;
    private String answerOptions;
    private String correctAnswers;


    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(String questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public long getQuestionHashCode() {

        return questionHashCode;
    }

    public void setQuestionHashCode(long questionHashCode) {
        this.questionHashCode = questionHashCode;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(String answerOptions) {
        this.answerOptions = answerOptions;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(String correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionListDTO that = (QuestionListDTO) o;
        return questionHashCode == that.questionHashCode &&
                Objects.equals(questionName, that.questionName) &&
                Objects.equals(questionContent, that.questionContent) &&
                Objects.equals(questionCategory, that.questionCategory) &&
                Objects.equals(questionType, that.questionType) &&
                Objects.equals(answerType, that.answerType) &&
                Objects.equals(questionDifficulty, that.questionDifficulty) &&
                Objects.equals(answerOptions, that.answerOptions) &&
                Objects.equals(correctAnswers, that.correctAnswers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionHashCode, questionName, questionContent, questionCategory, questionType, answerType, questionDifficulty, answerOptions, correctAnswers);
    }

    @Override
    public String toString() {
        return "QuestionListDTO{" +
                "questionHashCode=" + questionHashCode +
                ", questionName='" + questionName + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", questionCategory='" + questionCategory + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answerType='" + answerType + '\'' +
                ", questionDifficulty='" + questionDifficulty + '\'' +
                ", answerOptions='" + answerOptions + '\'' +
                ", correctAnswers='" + correctAnswers + '\'' +
                '}';
    }
}
