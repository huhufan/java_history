package com.example.casedemo.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class MyController {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
          if (!StringUtils.isEmpty(username) && password.equals("123456")){
              session.setAttribute("loginUser",username);
              return "redirect:/main";
          }
          else{
              map.put("msg","用户名或密码错误");
              return "login";
          }
    }

}
