package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.model.StudentQuestion;
import com.watchingy.service.StudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/StudentQuestion")
public class StudentQuestionController {
    @Autowired
    private StudentQuestionService studentQuestionService;

    @ResponseBody
    @RequestMapping(value = "/create")
    public String createStudentQuestion(@RequestBody String requestJson){
        if (requestJson == null) {
            return "error";
        }
        try {
            StudentQuestion studentQuestion= JSON.parseObject(requestJson, StudentQuestion.class);
            //将中文课程名转为utf-8编码
            String title=studentQuestion.getTitle();
            String content=studentQuestion.getContent();
            studentQuestion.setTitle( new String(title.getBytes("ISO8859-1"), "utf-8"));
            studentQuestion.setContent( new String(content.getBytes("ISO8859-1"), "utf-8"));
            studentQuestionService.createStudentQuestion(studentQuestion);
            return "successful";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getBycourseId",produces = "application/json;charset=UTF-8")
    public String getStudentQuestion(@RequestBody String requestJson){
        try {
            StudentQuestion studentQuestion= JSON.parseObject(requestJson, StudentQuestion.class);
            int courseId=studentQuestion.getCourseId();
            List<StudentQuestion> infoList = studentQuestionService.getStudentQuestionByCourseId(courseId);
            return JSON.toJSONString(infoList);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String deleteStudentQuestion(@RequestBody String requestJson){
        StudentQuestion studentQuestion=JSON.parseObject(requestJson,StudentQuestion.class);
        int questionId = studentQuestion.getQuestionId();
        studentQuestionService.deleteStudentQuestion(questionId);
        return"successful";
    }

    @ResponseBody
    @RequestMapping(value = "/reply")
    public String replyStudentQuestion(@RequestBody String requestJson){
        if (requestJson == null) {
            return "error";
        }
        try {
            StudentQuestion studentQuestion= JSON.parseObject(requestJson, StudentQuestion.class);
            //将中文课程名转为utf-8编码
            String reply=studentQuestion.getReply();
            studentQuestion.setReply( new String(reply.getBytes("ISO8859-1"), "utf-8"));
            studentQuestionService.addReply(studentQuestion);
            return "successful";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }


}
