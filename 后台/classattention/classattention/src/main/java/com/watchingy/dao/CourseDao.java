package com.watchingy.dao;

import com.watchingy.model.Course;

import java.util.List;

public interface CourseDao {
    void add(Course course);
    List<Course> getByUid(String uid);
    void delete(int uid);
}
