package com.watchingy.dao;

import com.watchingy.model.StudentQuestion;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<StudentQuestion> getByUid(String uid) {
        return sqlSession.selectList("com.watchingy.dao.StudentQuestionDao.getByUid", uid);
    }

    @Override
    public List<StudentQuestion> getByCourseId(int courseId){
        return sqlSession.selectList("com.watchingy.dao.StudentQuestionDao.getByCourseId", courseId);
    }
    @Override
    public void delete(int questionId){
        sqlSession.delete("com.watchingy.dao.StudentQuestionDao.detele",questionId);
    }

    @Override
    public void updateTitle( int questionId,String title) {
        Map<String, Object> param = new HashMap();
        param.put("title", title);
        param.put("questionId", questionId);
        sqlSession.update("com.watchingy.dao.StudentQuestionDao.updateTitle", param);
    }
    @Override
    public void updateContent(int questionId,String content){
        Map<String, Object> param = new HashMap();
        param.put("content", content);
        param.put("questionId", questionId);
        sqlSession.update("com.watchingy.dao.StudentQuestionDao.updateContent", param);
    }
    @Override
    public void updateReply(int questionId,String reply){
        Map<String, Object> param = new HashMap();
        param.put("reply", reply);
        param.put("questionId", questionId);
        sqlSession.update("com.watchingy.dao.StudentQuestionDao.updateReply", param);
    }
    @Override
    public void updateIsPublic(int questionId,int isPublic){
        Map<String, Object> param = new HashMap();
        param.put("isPublic", isPublic);
        param.put("questionId", questionId);
        sqlSession.update("com.watchingy.dao.StudentQuestionDao.updateIsPublic", param);
    }
    @Override
    public void updateIsReply(int questionId,int isReply){
        Map<String, Object> param = new HashMap();
        param.put("isReply", isReply);
        param.put("questionId", questionId);
        sqlSession.update("com.watchingy.dao.StudentQuestionDao.updateIsReply", param);
    }

    @Override
    public void addReply(int questionId,String reply){
        updateReply(questionId,reply);
        updateIsReply(questionId,1);
    }
}
