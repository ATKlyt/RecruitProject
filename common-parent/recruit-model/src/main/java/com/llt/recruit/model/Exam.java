package com.llt.recruit.model;

import java.util.List;
import java.util.Date;

public class Exam {
    private String paperName;
    private Date beginTime;
    private Integer paperCore;//题目
    private List<Subject> subjects;
    private Date endTime;


    @Override
    public String toString() {
        return "Exam{" +
                "paperName='" + paperName + '\'' +
                ", beginTime=" + beginTime +
                ", paperCore=" + paperCore +
                ", subjects=" + subjects +
                ", endTime=" + endTime +
                '}';
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getPaperCore() {
        return paperCore;
    }

    public void setPaperCore(Integer paperCore) {
        this.paperCore = paperCore;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}