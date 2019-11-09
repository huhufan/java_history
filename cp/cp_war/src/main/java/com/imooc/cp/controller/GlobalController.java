package com.imooc.cp.controller;

import com.imooc.cp.biz.EmployeeBiz;
import com.imooc.cp.biz.GlobalBiz;
import com.imooc.cp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.lob.TemporaryLobCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")
public class GlobalController {
    @Autowired
    private GlobalBiz globalBiz;
    @RequestMapping("/to_login")
    public String to_login(){
        return "login";
    }
    @RequestMapping("/self")
    public String self(){
        return "self";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee employee = globalBiz.login(sn, password);
        if (employee != null){
            session.setAttribute("employee",employee);
            return "redirect:self";
        }
        return "redirect:to_login";
    }
    @RequestMapping("to_change_password")
    public String to_change_password(){
        return "change_password";
    }
    @RequestMapping("/change_password")
    public String change_password(HttpSession session,@RequestParam String old,@RequestParam String new1,@RequestParam String new2){
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(old)){
            if (new1.equals(new2)){
                employee.setPassword(new1);
                globalBiz.changPassord(employee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password ";
    }
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }
}
