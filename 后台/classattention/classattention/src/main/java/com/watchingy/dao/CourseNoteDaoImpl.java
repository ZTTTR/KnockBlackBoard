package com.watchingy.dao;

import com.watchingy.model.CourseNote;
import org.apache.ibatis.session.SqlSession;

public class CourseNoteDaoImpl implements CourseNoteDao {
    SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(CourseNote courseNote) {
        sqlSession.insert("com.watchingy.dao.CourseNoteDao", courseNote);
//        sqlSession.commit();
    }
    @Override
    public void delete(int courseNoteId){
        sqlSession.delete("com.watchingy.dao.CourseDao.delete",courseNoteId);
    }
    @Override
    public CourseNote getByCourseId(int courseId) {
        return (CourseNote) sqlSession.selectOne("com.watchingy.dao.CourseNoteDao", courseId);
    }

}
