package com.llt.recruit.model;

public class Answer {
    private Long id;

    private Long questionId;

    private String answerName;

    private String answerType;


    public Answer() {}
    public Answer(Long questionId, String answerName, String answerType) {
        this.questionId = questionId;
        this.answerName = answerName;
        this.answerType = answerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName == null ? null : answerName.trim();
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType == null ? null : answerType.trim();
    }
}