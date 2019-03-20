package com.watchingy.dao;

import com.watchingy.model.CourseNote;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseNoteDaoImpl implements CourseNoteDao {
    SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(CourseNote courseNote) {
        sqlSession.insert("com.watchingy.dao.CourseNoteDao.add", courseNote);
//        sqlSession.commit();
    }
    @Override
    public void delete(int courseNoteId){
        sqlSession.delete("com.watchingy.dao.CourseNoteDao.delete",courseNoteId);
    }
    @Override
    public List<CourseNote> getByCourseId(int courseId) {
        return  sqlSession.selectList("com.watchingy.dao.CourseNoteDao.getByCourseId", courseId);
    }

}
