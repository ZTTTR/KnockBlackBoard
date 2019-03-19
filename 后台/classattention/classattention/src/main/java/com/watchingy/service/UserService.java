package com.watchingy.service;

import com.watchingy.dao.UserInfoDao;
import com.watchingy.dao.UserInfoDaoImpl;
import com.watchingy.exception.UserException;
import com.watchingy.model.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class UserService {
    private UserInfo userInfo;

    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-db.xml");
    private UserInfoDaoImpl userInfoDao = (UserInfoDaoImpl) context.getBean("userInfoDao");

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
    public boolean verifyEmail(String email){
        userInfo = userInfoDao.findByEmail(email);
        if(userInfo != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyUsername(String username){
        userInfo = userInfoDao.findByUsername(username);
        if(userInfo != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean verifyPhone(String phone){
        userInfo = userInfoDao.findByPhone(phone);
        if(userInfo != null){
            return false;
        }else{
            return true;
        }
    }


    public void register(UserInfo form) throws UserException {
        if(!(verifyEmail(form.getEmail()) && verifyPhone(form.getPhone()) && verifyUsername(form.getUsername()))){
            throw new UserException("Error");
        }
        if (form.getUid() == null || form.getUid().isEmpty()) {
            form.setUid(uuid());
        }
        form.setHavingClass(-1);
        form.setUclassNumber(0);
        form.setTrueName("NULL");
        form.setSchoolId("NULL");
        userInfoDao.add(form);
    }

    public void activate(String code) throws UserException {
        UserInfo userInfo = userInfoDao.findByCode(code);
        if (userInfo == null) throw new UserException("激活失败");
        if (userInfo.isState()) throw new UserException("已激活");

        userInfoDao.updateState(userInfo.getUid(), true);
    }

    public UserInfo login(String username, String password) {
        UserInfo userInfo = userInfoDao.findByUsername(username);
        if (userInfo == null) {
            return null;
        }
        if (userInfoDao.checkPassword(username, password) != null)
            return userInfo;
        return null;
    }
    public void updatePersonDate(String uid,String userPhone,String userEmail,String userTruename,String SchoolNumber){
        if(userPhone==null){
            userPhone="00000000";
        }
        if(userEmail==null){
            userEmail="00000000";
        }
        if(userTruename==null){
            userTruename="00000000";
        }
        if(SchoolNumber==null){
            SchoolNumber="00000000";
        }
        userInfoDao.updatePhone(uid,userPhone);
        userInfoDao.updateEmail(uid,userEmail);
        userInfoDao.updateTrueName(uid,userTruename);
        userInfoDao.updateSchoolNumber(uid,SchoolNumber);
    }
    public void havingClass(String uid, int classId) {
        userInfoDao.updateHavingClass(uid, classId);
    }

    public UserInfo getUserByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

    public UserInfo getUserByUid(String uid) {
        return userInfoDao.findByUid(uid);
    }
}
