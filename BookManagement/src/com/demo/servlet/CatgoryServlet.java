package com.demo.servlet;

import com.demo.utils.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatgoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String catgoryName = req.getParameter("catgoryName");
        String des = req.getParameter("description");
        new LibDaoImpl().addBookCatgory(id,catgoryName,des);
        req.setAttribute("hint","添加成功");
        req.getRequestDispatcher("WEB-INF/views/catgory.jsp").forward(req,resp);
    }
}
