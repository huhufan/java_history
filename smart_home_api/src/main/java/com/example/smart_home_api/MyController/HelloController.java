package com.example.smart_home_api.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public Map<String,Object> hello(){
        Map<String , Object> map = new HashMap<>();
        map.put("address","733");
        map.put("name","733智能家居委员会");
        map.put("message","hello");
        return map;
    }
}
