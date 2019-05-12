package com.llt.recruit.model;

import java.util.Date;

public class Time {
    private Long id;

    private Date beginTime;

    private String type;

    private Integer amountLimit;

    private Integer amount;

    private Date endTime;

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", type='" + type + '\'' +
                ", amountLimit=" + amountLimit +
                ", amount=" + amount +
                ", endTime=" + endTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(Integer amountLimit) {
        this.amountLimit = amountLimit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}