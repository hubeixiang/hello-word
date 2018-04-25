package com.sven.springboot.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Date;

/**
 * Created by 123 on 2016/8/12.
 */
public class ResultInfo {
    private int code;
    private String message;
    private Date timestamp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JsonGetter("data")
    public String getTimestampStr() {
        return this.timestamp + "===";
    }
}
