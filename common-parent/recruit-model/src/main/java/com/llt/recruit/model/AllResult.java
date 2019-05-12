package com.llt.recruit.model;

public class AllResult {
    private Long id;

    private Integer blankResult;

    private Integer choiceResult;

    private Long userId;

    private Integer writeResult;

    private Integer interviewResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBlankResult() {
        return blankResult;
    }

    public void setBlankResult(Integer blankResult) {
        this.blankResult = blankResult;
    }

    public Integer getChoiceResult() {
        return choiceResult;
    }

    public void setChoiceResult(Integer choiceResult) {
        this.choiceResult = choiceResult;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getWriteResult() {
        return writeResult;
    }

    public void setWriteResult(Integer writeResult) {
        this.writeResult = writeResult;
    }

    public Integer getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(Integer interviewResult) {
        this.interviewResult = interviewResult;
    }
}