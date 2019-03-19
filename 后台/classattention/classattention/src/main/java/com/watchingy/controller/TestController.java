package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.dao.TestDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/test")
    String test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-db.xml");
        TestDaoImpl testDao = (TestDaoImpl) context.getBean("testDao");
        return JSON.toJSONString(testDao.testSelect("123"));
    }
}
