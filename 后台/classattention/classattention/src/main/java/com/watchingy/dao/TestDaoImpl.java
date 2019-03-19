package com.watchingy.dao;

import com.watchingy.model.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDaoImpl implements TestDao {
    private SqlSession sqlSession;
    @Override
    public UserInfo testSelect(String username) {
        return (UserInfo) sqlSession.selectOne("com.watchingy.dao.TestDao.testSelect", username);
    }

    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
}
