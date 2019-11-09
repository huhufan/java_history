package com.demo.servlet;

import com.demo.utils.LibDaoImpl;
import com.demo.utils.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password = req.getParameter("password");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        User user=new User(username,password,phone,email);
        LibDaoImpl libDao=new LibDaoImpl();
        libDao.regist(user);
        resp.sendRedirect("/login");
    }
}
