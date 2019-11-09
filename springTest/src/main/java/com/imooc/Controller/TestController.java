package com.imooc.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public String  get(){
        System.out.println("进入get");
        return "one";
    }
}
