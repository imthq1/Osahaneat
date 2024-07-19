package com.food.Osahaneat.payLoad;

public class ResponseDate {
    private int status=200;
    private String desc;
    private Object data;
    private boolean isSuccess=true;
    public int getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
