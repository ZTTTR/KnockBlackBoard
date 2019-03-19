package com.watchingy.dao;

import com.watchingy.model.CourseNote;

import java.util.List;

public interface CourseNoteDao {
    void add(CourseNote courseNote);
    List<CourseNote> getByCourseId(int courseId);
     void delete(int courseNoteId);
}
