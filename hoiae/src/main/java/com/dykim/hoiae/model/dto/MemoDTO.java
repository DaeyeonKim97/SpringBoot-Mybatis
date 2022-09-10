package com.dykim.hoiae.model.dto;

import java.util.Date;

public class MemoDTO {
    private int code;
    private String title;
    private String content;
    private Date createDate;
    private String state;

    public MemoDTO() {};

    public MemoDTO(int code, String title, String content, Date createDate, String state) {
        this.code = code;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MemoDTO{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", state='" + state + '\'' +
                '}';
    }
}
