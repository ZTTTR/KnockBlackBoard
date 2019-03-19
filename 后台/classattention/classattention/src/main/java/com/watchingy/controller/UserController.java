package com.watchingy.controller;

import com.alibaba.fastjson.JSON;
import com.watchingy.exception.UserException;
import com.watchingy.model.UserInfo;
import com.watchingy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 验证邮箱
    * 可以用于注册时Ajax异步查询，邮箱是否已经被使用
    */
    @RequestMapping(value = "/verifyEmail")
    @ResponseBody
    public String verifyEmail(@RequestBody String email){
        if(userService.verifyEmail(email)){
            return "ok";
        }else {
            return "error";
        }
    }

    /*
    *验证手机
    * 用于注册时Ajax异步查询，手机号码是否已经被使用
     */
    @RequestMapping(value = "/verifyPhone")
    @ResponseBody
    public String verifyPhone(@RequestBody String phone){
        if(userService.verifyPhone(phone)){
            return "ok";
        }else{
            return "error";
        }

    }

    /*
    *验证用户名
    * 用于注册时Ajax异步查询，用户名是否已经存在
     */
    @RequestMapping(value = "/verifyUsername")
    @ResponseBody
    public String verifyUsername(@RequestBody String username){
        if(userService.verifyUsername(username)){
            return "ok";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody String json){
        try {
            UserInfo userInfo = JSON.parseObject(json, UserInfo.class);
            userService.register(userInfo);
            return "successful";
        } catch (UserException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String json){
        UserInfo request = JSON.parseObject(json, UserInfo.class);
        UserInfo userInfo = userService.login(request.getUsername(), request.getPassword());
        if(userInfo == null){
            return "error";
        }else{
            return JSON.toJSONString(userInfo);
        }
    }
    @RequestMapping(value = "/editPersonDate", method = RequestMethod.POST)
    @ResponseBody
    public String EditPersonDate(@RequestBody String json){
            UserInfo request = JSON.parseObject(json, UserInfo.class);
            String uid=request.getUid();
            if(uid==null){
                return "尚未登录";
            }
            String userPhone=request.getPhone();
            String userEmail=request.getEmail();
            String  userTrueName=request.getTrueName();
            String SchoolNumber=request.getSchoolId();
            userService.updatePersonDate(uid,userPhone,userEmail,userTrueName,SchoolNumber);
            return "successful";
    }
    @RequestMapping(value = "/getPersonDateByName", method = RequestMethod.POST)
    @ResponseBody
    public String getPersonDateByName(@RequestBody String json){
        UserInfo request = JSON.parseObject(json, UserInfo.class);
        UserInfo userInfo=userService.getUserByUsername(request.getUsername());
        if(userInfo==null){
            return "尚未登录";
        }
        else{
            return JSON.toJSONString(userInfo);
        }
    }
}
