package com.watchingy.vo;

import com.watchingy.model.AppInfo;

import java.util.List;

public class StudentAppInfoVo {
    private String trueName;
    private String schoolId;
    private String appInfoList;

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

    public String getAppInfoList() {
        return appInfoList;
    }

    public void setAppInfoList(String appInfoList) {
        this.appInfoList = appInfoList;
    }
}
