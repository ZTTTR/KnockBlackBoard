package com.watchingy.dao;

import com.watchingy.model.Course;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(Course course) {
        sqlSession.insert("com.watchingy.dao.CourseDao.add", course);
//        sqlSession.commit();
    }

    @Override
    public List<Course> getByUid(String uid) {
        return sqlSession.selectList("com.watchingy.dao.CourseDao.getByUid", uid);
    }
    @Override
    public void delete(int uid){
        sqlSession.delete("com.watchingy.dao.CourseDao.delete",uid);
    }
}
