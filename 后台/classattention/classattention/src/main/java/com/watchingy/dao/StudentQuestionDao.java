package com.watchingy.dao;

import com.watchingy.model.StudentQuestion;

import java.util.List;

public interface StudentQuestionDao {
    void add(StudentQuestion studentQuestion);
    List<StudentQuestion> getByUid(int classId);
}
