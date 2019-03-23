package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import  com.watchingy.model.Class;
import com.watchingy.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/Class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/create")
    public String create(@RequestBody String json){
        Class myclass= JSON.parseObject(json, Class.class);

//        //将中文课程名转为utf-8编码
//        String className=myclass.get();
        try {
            course.setCourseName( new String(courseName.getBytes("ISO8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        classService.startClass(course);
        return "ok";
    }
//
//    /*
//    *根据uid返回课堂列表
//     */
//    @RequestMapping(value = "/getInfoById", produces = "application/json;charset=UTF-8")
//    public String getInfo(@RequestBody String request){
//        try {
//            Course course= JSON.parseObject(request, Course.class);
//            String uid=course.getUid();
//            List<Course> infoList = courseService.getCourseInfo(uid);
//            return JSON.toJSONString(infoList);
//        } catch (Exception e){
//            e.printStackTrace();
//            return "error";
//        }
//    }
//    @RequestMapping(value = "/delete")
//    public String delete(@RequestBody String json){
//        Course course= JSON.parseObject(json, Course.class);
//        int courseID=course.getCourseId();
////        String uid=course.getUid();
//        courseService.deleteCourse(courseID);
//        return "ok";
//    }
}