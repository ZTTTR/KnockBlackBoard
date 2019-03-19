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
        System.out.println(requestJson);
        StudentQuestion studentQuestion= JSON.parseObject(requestJson, StudentQuestion.class);
        studentQuestionService.createStudentQuestion(studentQuestion);
        return "successful";
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public String getStudentQuestion(@RequestBody String requestJson){
        int classId = Integer.parseInt(requestJson);
        return JSON.toJSONString(studentQuestionService.getStudentQuestion(classId));
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String deleteStudentQuestion(@RequestBody String requestJson){
        int questionId = Integer.parseInt(requestJson);
        studentQuestionService.deleteStudentQuestion(questionId);
        return"successful";
    }


}
