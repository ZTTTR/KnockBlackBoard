package com.watchingy.service;

import com.watchingy.dao.CourseDao;
import com.watchingy.dao.CourseDaoImpl;
import com.watchingy.model.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseService {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-db.xml");
    private CourseDaoImpl courseDao = (CourseDaoImpl) context.getBean("courseDao");

    public void createCourse(Course course) {
        //使用uid以及dateid创建数据库
        courseDao.add(course);
    }

    public List<Course> getCourseInfo(String uid) {
        return courseDao.getByUid(uid);
    }

    public void deleteCourse(int uid){
        courseDao.delete(uid);
    }
}
