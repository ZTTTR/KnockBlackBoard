package com.watchingy.model;

public class Course {

    private String uid;
    private int courseId;
    private String courseName;



    private String createTime;
    private int peopleNumber;




    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCreateTime() {
        return createTime;
    }



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    @Override
    public String toString() {
        return "Course{" +
                "uid='" + uid + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", createTime=" + createTime +
                ", peopleNumber=" + peopleNumber +
                '}';
    }
}
