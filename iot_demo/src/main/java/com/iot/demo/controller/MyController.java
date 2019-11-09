package com.iot.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public Map<String,Object> hello(@PathParam("one") String one, @PathParam("two") String two){
        Map<String,Object> map = new HashMap<>();
        map.put("one",one);
        map.put("two",two);
        map.put("这是测试汉字编码","我是正常的吗?");
       return map;
    }

}
