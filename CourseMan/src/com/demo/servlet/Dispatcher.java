package com.demo.servlet;


import com.demo.datapro.CourseDaoImpl;
import com.demo.datapro.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


public class Dispatcher extends HttpServlet {
    CourseService service = new CourseService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/top",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/top.jsp").forward(req,resp);
        }
        if (Objects.equals("/left",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/left.jsp").forward(req,resp);
        }
        if (Objects.equals("/addUser",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/addUser.jsp").forward(req,resp);
        }
        if (Objects.equals("/selectUser",req.getServletPath())){
            req.setAttribute("list", service.getAllUsers());
            req.getRequestDispatcher("WEB-INF/views/selectUsers.jsp").forward(req,resp);
        }
        if (Objects.equals("/delete",req.getServletPath())){
            String username = (String)req.getParameter("username");
            service.delUser(username);
            resp.sendRedirect("/selectUser");
        }if (Objects.equals("/index",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req,resp);
        }if (Objects.equals("/server",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/server.jsp").forward(req,resp);
        }
    }
}
