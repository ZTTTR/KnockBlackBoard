package com.watchingy.service;

import com.watchingy.dao.CourseNoteDao;
import com.watchingy.dao.CourseNoteDaoImpl;
import com.watchingy.model.CourseNote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseNoteService {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-db.xml");
    private CourseNoteDaoImpl courseNoteDao = (CourseNoteDaoImpl) context.getBean("courseNoteDao");


    public void createCourseNote(CourseNote courseNote) {
        //使用uid以及deteid创建数据库
        courseNoteDao.add(courseNote);
    }
    public void deleteCourseNote(int courseNoteId){
        courseNoteDao.delete(courseNoteId);
    }
    public List<CourseNote> getCourseNote(int courseId) {
        return courseNoteDao.getByCourseId(courseId);
    }

}
