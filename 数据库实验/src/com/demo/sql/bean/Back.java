package com.demo.sql.bean;

public class Back {
    private String uid;
    private String title;
    private String content;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Back(String uid, String title, String content) {
        this.uid = uid;
        this.title = title;
        this.content = content;
    }
}
