package com.example.smart_home_api2.MyController;

import com.example.smart_home_api2.entity.Motto;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model){
        String motto = Motto.getMotto(name);
        String zname = Motto.getName(name);
        if (motto==null)
            motto="我是空的哦！";
        if (zname==null)
            zname="我还没有名字的哦！";
        model.addAttribute("name",zname);
        model.addAttribute("motto",motto);
        if ("cxk".equals(name))
            model.addAttribute("imgUrl","/asserts/img/"+name+".gif");
        else
            model.addAttribute("imgUrl","/asserts/img/"+name+".png");
        return "show";
    }
    @RequestMapping(value = {"/hello","/"})
    public String he(Model model){
        return "strange";
    }
}
