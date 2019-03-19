package com.watchingy.dao;

import com.watchingy.model.Class;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassDaoImpl implements ClassDao {
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public Class getByUidAndTime(String uid, long createTime) {
        return (Class) sqlSession.selectOne("com.watcingy.dao.ClassDao.getByUidAndTime", uid);
    }

    @Override
    public List<Class> getByUid(String id) {
        return sqlSession.selectList("com.watchingy.dao.ClassDao.getByUid", id);
    }

    @Override
    public void add(Class aClass) {

        sqlSession.insert("com.watchingy.dao.ClassDao.add", aClass);
        sqlSession.commit();
    }

    @Override
    public int getClassOrder(String uid) {
        return sqlSession.selectOne("com.watchingy.dao.ClassDao.getClassOrder", uid);
    }
}
