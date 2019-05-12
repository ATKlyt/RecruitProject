package com.llt.recruit.model;

import java.util.List;

public class Subject {
    //穿试卷id或name进去，找到试卷所属题目，再通过题目id找到所有题目所属答案，将正确答案封装在List<Subject>
    private Long questionId;
    private String questionName;
    private String type;
    private List<String> options;
    private List<String> rightOptions;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getRightOptions() {
        return rightOptions;
    }

    public void setRightOptions(List<String> rightOptions) {
        this.rightOptions = rightOptions;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "questionId=" + questionId +
                ", questionName='" + questionName + '\'' +
                ", type='" + type + '\'' +
                ", options=" + options +
                ", rightOptions=" + rightOptions +
                '}';
    }
}




