package com.dykim.hoiae.model.dto;

import java.util.Date;

public class ReplyDTO {
    private int code;
    private String author;
    private String content;
    private Date createDate;
    private String state;
    private int memoCode;

    ReplyDTO(){}

    public ReplyDTO(int code, String author, String content, Date createDate, String state, int memoCode) {
        this.code = code;
        this.author = author;
        this.content = content;
        this.createDate = createDate;
        this.state = state;
        this.memoCode = memoCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getMemoCode() {
        return memoCode;
    }

    public void setMemoCode(int memoCode) {
        this.memoCode = memoCode;
    }

    @Override
    public String toString() {
        return "ReplyDTO{" +
                "code=" + code +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", state='" + state + '\'' +
                ", memoCode=" + memoCode +
                '}';
    }
}
