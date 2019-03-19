package com.watchingy.dao;

import com.watchingy.model.CourseNote;

public interface CourseNoteDao {
    void add(CourseNote courseNote);
    CourseNote getByCourseId(int courseId);
     void delete(int courseNoteId);
}
