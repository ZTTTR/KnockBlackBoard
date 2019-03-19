package com.watchingy.service;


import com.watchingy.dao.ClassDao;
import com.watchingy.model.Class;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class ClassService {
    ClassDao classDao;
    UserService userService = new UserService();

    public ClassService() throws IOException {
    }

    public void startClass(Class classForm) {
        //使用uid以及deteid创建数据库
        classForm.setClassOrder(classDao.getClassOrder(classForm.getUid())+1);
        Instant.now().getEpochSecond();
        classDao.add(classForm);
        Class aClass = classDao.getByUidAndTime(classForm.getUid(), classForm.getStartClassTime());
        userService.havingClass(aClass.getUid(), aClass.getClassId());
    }

    public List<Class> getByUid(String uid) {
        return classDao.getByUid(uid);
    }

    public Class getClassInfo(String uid, long timestamp) {
        Class aClass = classDao.getByUidAndTime(uid, timestamp);
        return aClass;
    }

}
