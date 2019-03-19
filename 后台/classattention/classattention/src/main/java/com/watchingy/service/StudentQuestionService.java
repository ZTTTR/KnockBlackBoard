package com.watchingy.service;

import com.watchingy.dao.StudentQuestionDao;
import com.watchingy.dao.StudentQuestionDaoImpl;
import com.watchingy.model.StudentQuestion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentQuestionService {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-db.xml");
    private StudentQuestionDaoImpl studentQuestionDao = (StudentQuestionDaoImpl) context.getBean("studentQuestionDao");

    public void createStudentQuestion(StudentQuestion studentQuestion) {
        //使用uid以及deteid创建数据库
        studentQuestionDao.add(studentQuestion);
    }

    public List<StudentQuestion> getStudentQuestion(int classId) {
        return studentQuestionDao.getByUid(classId);
    }

    public void deleteStudentQuestion(int questionId){
        studentQuestionDao.delete(questionId);
    }
}
