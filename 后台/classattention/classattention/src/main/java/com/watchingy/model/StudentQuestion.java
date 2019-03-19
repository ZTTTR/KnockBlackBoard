package com.watchingy.model;

public class StudentQuestion {

    private int qId;
    private int course_id;
    private int uid;
    private String title;
    private String content;
    private String reply;
    private int is_public;
    private int classId;
    private int is_reply;
    private String create_time;


    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getIs_public() {
        return is_public;
    }

    public void setIs_public(int is_public) {
        this.is_public = is_public;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getIs_reply() {
        return is_reply;
    }

    public void setIs_reply(int is_reply) {
        this.is_reply = is_reply;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "StudentQuestion{" +
                "qId=" + qId +
                ", course_id=" + course_id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                ", is_public=" + is_public +
                ", classId=" + classId +
                ", is_reply=" + is_reply +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
