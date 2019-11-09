package com.demo.servlet;

import com.demo.datapro.CourseService;
import com.demo.datapro.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
//        if(username.equals("") || password.equals("")){
//            req.setAttribute("hint","账号和密码不能为空");
//            req.getRequestDispatcher("WEB-INF/views/addUser.jsp")
//            return;
//        }
        CourseService courseService = new CourseService();
        courseService.addUser(username,password);
        resp.sendRedirect("/selectUser");


    }
}
