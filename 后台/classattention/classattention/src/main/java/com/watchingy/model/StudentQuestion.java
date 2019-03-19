package com.watchingy.model;

public class StudentQuestion {
    private int qId;
    private String title;
    private String content;
    private String reply;
    private int publicOrNot;
    private int classId;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getPublicOrNot() {
        return publicOrNot;
    }

    public void setPublicOrNot(int publicOrNot) {
        this.publicOrNot = publicOrNot;
    }
}
