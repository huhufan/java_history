package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther hu  .
 * @create 2019/9/15
 */
@Controller
public class MyController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
