package com.demo.servlet;

import com.demo.utils.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/LoginServlet",req.getServletPath())){
            String username= req.getParameter("username");
            String password= req.getParameter("password");
            int a= new LibDaoImpl().login(username,password);
            if (a==1){
                req.getSession().setAttribute("username",username);
                req.getRequestDispatcher("WEB-INF/views/server.jsp").forward(req,resp);
            }
            if (a==0){
                req.setAttribute("hint","账号或密码错误");
                req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req,resp);
            }
        }
    }
}
