package com.llt.recruit.model;

public class ResultInfo {
    private boolean flag;//后端返回结果正常为true，发生异常返回false
    private Object data;//后端返回结果数据对象
    private String tipMsg;//发生异常的错误消息

    public ResultInfo(boolean flag, String tipMsg) {
        this.flag = flag;
        this.tipMsg = tipMsg;
    }

    public ResultInfo(boolean flag, Object data, String tipMsg) {
        this.flag = flag;
        this.data = data;
        this.tipMsg = tipMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTipMsg() {
        return tipMsg;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ResultInfo(boolean flag) {
        this.flag = flag;
    }
}













