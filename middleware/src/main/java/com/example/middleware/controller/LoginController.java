package com.example.middleware.controller;

import com.example.middleware.entity.Dl;
import com.example.middleware.service.DlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private DlService dlService;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping ("/login")
    public String login(@RequestParam("xm") String xm,
                        @RequestParam("pw") String pw,
                        @RequestParam("checkCode") String checkCode,
                        Map<String,Object> map, HttpSession session){
        String checkCode1 = (String) session.getAttribute("checkCode");
        if (!checkCode.equals(checkCode1)) {
            map.put("msg", "验证码错误");
            return "login";
        }
        Dl dl = dlService.getByXM(xm);
        if (dl!=null && dl.getPw().equals(pw)){
            session.setAttribute("user",dl);
            return "redirect:/show";
        }
        else{
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }


    @GetMapping("/loginOut")
    public String out(HttpSession session){
        session.setAttribute("user",null);
        return "index";
    }
}
