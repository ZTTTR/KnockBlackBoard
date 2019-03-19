package com.watchingy.model;

public class Class {
    private int classId;
    private String uid;
    private long startClassTime;
    private int classOrder;


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getStartClassTime() {
        return startClassTime;
    }

    public void setStartClassTime(long startClassTime) {
        this.startClassTime = startClassTime;
    }

    public int getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(int classOrder) {
        this.classOrder = classOrder;
    }


    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", uid='" + uid + '\'' +
                ", startClassTime=" + startClassTime +
                ", classOrder=" + classOrder +
                '}';
    }


}
