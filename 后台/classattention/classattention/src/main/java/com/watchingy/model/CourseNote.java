package com.watchingy.model;

public class CourseNote {


    private int courseNoteId;
    private int courseId;
    private String title;
    private String content;



    private String createTime;

    public int getCourseNoteId() {
        return courseNoteId;
    }

    public void setCourseNoteId(int courseNoteId) {
        this.courseNoteId = courseNoteId;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public String getTime() {
        return createTime;
    }
    public void setTime(String time) {
        this.createTime = time;
    }

    @Override
    public String toString() {
        return "CourseNote{" +
                "courseNoteId=" + courseNoteId +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
