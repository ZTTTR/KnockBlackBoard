package com.watchingy.dao;

import com.watchingy.model.Class;

import java.util.List;

public interface ClassDao {
    Class getByUidAndTime(String uid, long createTime);
    List<Class> getByUid(String id);
    void add(Class aClass);
    int getClassOrder(String uid);
}
