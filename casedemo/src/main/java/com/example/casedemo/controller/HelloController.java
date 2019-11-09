package com.example.casedemo.controller;

import com.example.casedemo.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        if (name.equals("aaa")){
            throw new UserNotExistException();
        }
        return "helloWorld";
    }
}
