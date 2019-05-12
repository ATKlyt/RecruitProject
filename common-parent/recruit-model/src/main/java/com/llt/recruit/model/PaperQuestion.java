package com.llt.recruit.model;

public class PaperQuestion {
    private Long id;

    private Long testPaperId;

    private Long questionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestPaperId() {
        return testPaperId;
    }

    public void setTestPaperId(Long testPaperId) {
        this.testPaperId = testPaperId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }


    @Override
    public String toString() {
        return "PaperQuestion{" +
                "id=" + id +
                ", testPaperId=" + testPaperId +
                ", questionId=" + questionId +
                '}';
    }
}