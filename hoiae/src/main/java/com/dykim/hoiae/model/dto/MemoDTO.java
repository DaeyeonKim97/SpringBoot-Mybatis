package com.dykim.hoiae.model.dto;

public class MemoDTO {
    public int code;
    public String title;
    public String content;
    public String state;

    MemoDTO() {};

    public MemoDTO(int code, String title, String content, String state) {
        this.code = code;
        this.title = title;
        this.content = content;
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
                ", state='" + state + '\'' +
                '}';
    }
}
