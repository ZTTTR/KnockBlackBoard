package com.watchingy.dao;

import com.watchingy.model.StudentQuestion;

import java.util.List;

public interface StudentQuestionDao {
    void add(StudentQuestion studentQuestion);
    List<StudentQuestion> getByUid(String uid);
    List<StudentQuestion> getByCourseId(int courseId);
    void delete(int questionId);
    void updateTitle(int questionId,String title);
    void updateContent(int questionId,String content);
    void updateReply(int questionId,String reply);
    void updateIsPublic(int questionId,int isPublic);
    void updateIsReply(int questionId,int isReply);
    void addReply(int questionId,String reply);
}
