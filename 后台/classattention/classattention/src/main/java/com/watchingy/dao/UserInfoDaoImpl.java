package com.watchingy.dao;

import com.watchingy.model.UserInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class UserInfoDaoImpl implements UserInfoDao {
    SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public UserInfo findByUsername(String username) {
        return (UserInfo) sqlSession.selectOne("com.watchingy.dao.UserInfoDao.findByUsername", username);
    }

    @Override
    public UserInfo findByEmail(String email) {
        return (UserInfo) sqlSession.selectOne("com.watchingy.dao.UserInfoDao.findByEmail", email);
    }

    @Override
    public UserInfo findByPhone(String phone) {
        return (UserInfo) sqlSession.selectOne("com.watchingy.dao.UserInfoDao.findByPhone", phone);
    }

    @Override
    public UserInfo findByUid(String uid) {
        return (UserInfo) sqlSession.selectOne("com.watchingy.dao.UserInfoDao.findByUid", uid);
    }

    @Override
    public UserInfo findByCode(String code) {
        return (UserInfo) sqlSession.selectOne("com.watchingy.dao.UserInfoDao.findByCode", code);
    }

    @Override
    public void updateState(String uid, boolean state) {
        Map<String, Object> param = new HashMap();
        param.put("uid", uid);
        param.put("state", state);
        sqlSession.update("com.watchingy.dao.UserInfoDao.updateState", param);
//        sqlSession.commit();
    }

    @Override
    public void updateTrueName(String uid, String trueName) {
        Map<String, Object> param = new HashMap();
        param.put("uid", uid);
        param.put("trueName", trueName);
        sqlSession.update("com.watchingy.dao.UserInfoDao.updateTrueName", param);
//        sqlSession.commit();
    }

    @Override
    public void updateHavingClass(String uid, int classId) {
        Map<String, Object> param = new HashMap();
        param.put("uid", uid);
        param.put("classId", classId);
        sqlSession.update("com.watchingy.dao.UserInfoDao.updateHavingClass", param);
    }

    @Override
    public void updateSchoolNumber(String uid, String schoolNumber) {
        Map<String, Object> param = new HashMap();
        param.put("uid", uid);
        param.put("schoolNumber", schoolNumber);
        sqlSession.update("com.watchingy.dao.UserInfoDao.updateSchoolNumber", param);
    }

    @Override
    public void updatePhone(String uid, String phone) {
        Map<String, Object> param = new HashMap();
        param.put("uid", uid);
        param.put("phone", phone);
        sqlSession.update("com.watchingy.dao.UserInfoDao.updateSchoolNumber", param);
    }
    @Override
    public void updateEmail(String uid, String email) {
        Map<String, Object> param = new HashMap();
        param.put("uid", uid);
        param.put("email", email);
        sqlSession.update("com.watchingy.dao.UserInfoDao.updateSchoolNumber", param);
    }
    @Override
    public void updatePersonDate(UserInfo userInfo) {
        String phone=userInfo.getPhone();
        String email=userInfo.getEmail();
        String trueName=userInfo.getTrueName();
        String schoolID=userInfo.getSchoolId();
        sqlSession.update("com.watchingy.dao.UserInfo.",phone);
        sqlSession.update("com.watchingy.dao.UserInfo.",email);
        sqlSession.update("com.watchingy.dao.UserInfo.updateTrueName",trueName);
        sqlSession.update("com.watchingy.dao.UserInfo.",schoolID);
    }
    @Override
    public void add(UserInfo userInfo) {
        sqlSession.insert("com.watchingy.dao.UserInfoDao.add", userInfo);
//        sqlSession.commit();
    }

    @Override
    public UserInfo checkPassword(String username, String password) {
        Map<String, Object> param = new HashMap();
        param.put("password", password);
        param.put("username", username);
        return sqlSession.selectOne("com.watchingy.dao.UserInfoDao.checkPassword", param);
    }

    @Override
    public String getUid(String username) {
        return sqlSession.selectOne("com.watchingy.dao.UserInfo.getUid", username);
    }


}
