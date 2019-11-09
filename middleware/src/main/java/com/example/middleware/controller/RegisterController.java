package com.example.middleware.controller;

import com.example.middleware.entity.Dl;
import com.example.middleware.service.DlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    private DlService dlService;

    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("xm") String xm, @RequestParam("pw") String ps,
                           @RequestParam("checkCode") String checkCode, Map<String,Object> map ,HttpSession session){
        Object checkCode1 = session.getAttribute("checkCode");
        if (!checkCode.equals(checkCode1)) {
            map.put("msg", "验证码错误");
            return "register";
        }
        if (dlService.getByXM(xm)!=null){
            map.put("msg","用户已存在");
            return "register";
        }
        boolean b = dlService.add(new Dl(xm, ps));
        if (b){
            map.put("msg","注册成功，请登录");
            return "redirect:/toLogin";

        }
        else{
            map.put("msg","注册失败");
            return "register";
        }
    }
}

