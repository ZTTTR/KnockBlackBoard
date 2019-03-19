package com.watchingy.dao;

import com.watchingy.model.StudentQuestion;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentQuestionDaoImpl implements StudentQuestionDao{
    SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void add(StudentQuestion studentQuestion) {
        sqlSession.insert("com.watchingy.dao.StudentQuestion.add", studentQuestion);
        sqlSession.commit();
    }

    @Override
    public List<StudentQuestion> getByUid(int classId) {
        return sqlSession.selectList("com.watchingy.dao.StudentQuestion.getByUid", classId);
    }
}
