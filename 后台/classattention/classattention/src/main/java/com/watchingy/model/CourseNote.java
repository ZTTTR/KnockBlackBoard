package com.watchingy.model;

public class CourseNote {


    private int CourseNoteId;
    private int courseId;
    private String title;
    private String content;
    private int time;

    public int getCourseNoteId() {
        return CourseNoteId;
    }

    public void setCourseNoteId(int courseNoteId) {
        CourseNoteId = courseNoteId;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CourseNote{" +
                "CourseNoteId=" + CourseNoteId +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
