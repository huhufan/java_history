package com.imooc.sm.controller;

import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../login.jsp").forward(request,response);
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Staff s = selfService.login(account, password);
        if (s == null)
            response.sendRedirect("toLogin.do");
        else {
            request.getSession().setAttribute("USER", s);
            response.sendRedirect("main.do");
        }
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("USER",null);
        response.sendRedirect("toLogin.do");
    }
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../index.jsp").forward(request,response);
    }
    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request,response);
    }
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request,response);
    }
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        Staff staff = (Staff) request.getSession().getAttribute("USER");
        if (password.equals(staff.getPassword())){
            selfService.changePassword(staff.getId(),password1);
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"self/logout.do\"</script>");
        }
        else{
            request.getRequestDispatcher("../change_password.jsp").forward(request,response);
        }

    }
 }
