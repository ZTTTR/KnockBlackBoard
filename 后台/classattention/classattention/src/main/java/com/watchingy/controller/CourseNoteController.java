package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.model.Course;
import com.watchingy.model.CourseNote;
import com.watchingy.service.CourseNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/CourseNote")
public class CourseNoteController {
    @Autowired
    private CourseNoteService courseNoteService;

    @RequestMapping(value = "/create" )
    public String createCourseNote(@RequestBody String requestJson){
        if (requestJson == null) {
            return "error";
        }
        try {
            CourseNote courseNote = JSON.parseObject(requestJson, CourseNote.class);
            //将中文课程名转为utf-8编码
            String title=courseNote.getTitle();
            String content=courseNote.getContent();
            courseNote.setTitle( new String(title.getBytes("ISO8859-1"), "utf-8"));
            courseNote.setContent( new String(content.getBytes("ISO8859-1"), "utf-8"));

            courseNoteService.createCourseNote(courseNote);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/getInfo" ,produces = "application/json;charset=UTF-8")
    public String getCourseNote(@RequestBody String request){
        try {
            CourseNote courseNote= JSON.parseObject(request, CourseNote.class);
            int courseId=courseNote.getCourseId();
            List<CourseNote> infoList = courseNoteService.getCourseNote(courseId);
            return JSON.toJSONString(infoList);
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping(value = "/delete")
    public String delete(@RequestBody String json){
        CourseNote courseNote= JSON.parseObject(json, CourseNote.class);
        int courseNoteID=courseNote.getCourseNoteId();
//        String uid=course.getUid();
        courseNoteService.deleteCourseNote(courseNoteID);
        return "ok";
    }
}
