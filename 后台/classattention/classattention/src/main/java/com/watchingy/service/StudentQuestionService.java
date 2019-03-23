package com.watchingy.service;

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

    public List<StudentQuestion> getStudentQuestionByUid(String uid) {
        return studentQuestionDao.getByUid(uid);
    }

    public List<StudentQuestion> getStudentQuestionByCourseId(int courseId){
        return studentQuestionDao.getByCourseId(courseId);
    }
    public void deleteStudentQuestion(int questionId){
        studentQuestionDao.delete(questionId);
    }

    public void  addReply(StudentQuestion studentQuestion){
        studentQuestionDao.addReply(studentQuestion.getQuestionId(),studentQuestion.getReply());
    }
}
