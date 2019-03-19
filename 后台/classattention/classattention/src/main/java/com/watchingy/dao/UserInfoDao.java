package com.watchingy.dao;

import com.watchingy.model.UserInfo;

public interface UserInfoDao {
    UserInfo findByUsername(String username);

    UserInfo findByEmail(String email);

    UserInfo findByPhone(String phone);

    UserInfo findByUid(String uid);

    UserInfo findByCode(String code);

    void updatePhone(String uid, String phone);

    void updateEmail(String uid, String phone);

    void updatePersonDate(UserInfo userInfo);

    void updateState(String uid, boolean state);

    void updateTrueName(String uid, String trueName);

    void updateHavingClass(String uid, int classId);

    void updateSchoolNumber(String uid, String schoolNumber);

    void add(UserInfo userInfo);

    UserInfo checkPassword(String username, String password);

    String getUid(String username);
}
