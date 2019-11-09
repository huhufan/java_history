package com.example.casedemo.controller;

import com.example.casedemo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class MyControllerAdvice  {
    //@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public String exceptionHandle(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notExist");
        map.put("message",e.getMessage());
        request.setAttribute("txt",map);
        return "forward:/error";
    }
}
