package com.watchingy.model;

import java.util.List;

public class StudentAppInfo {
    private String uid;
    private int classId;
    private String trueName;
    private String schoolId;
    private String appInfoList;

    public String getUid() {
        return uid;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getAppInfoList() {
        return appInfoList;
    }

    public void setAppInfoList(String appInfoList) {
        this.appInfoList = appInfoList;
    }
}
