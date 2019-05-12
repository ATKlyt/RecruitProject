package com.llt.recruit.model;

public class BlankAnswer {
    private Long id;

    private Long userId;

    private Long questionId;

    private String blankAnswer;

    private Integer blankScore;

    private String status;

    private String questionName;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getBlankAnswer() {
        return blankAnswer;
    }

    public void setBlankAnswer(String blankAnswer) {
        this.blankAnswer = blankAnswer == null ? null : blankAnswer.trim();
    }

    public Integer getBlankScore() {
        return blankScore;
    }

    public void setBlankScore(Integer blankScore) {
        this.blankScore = blankScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}