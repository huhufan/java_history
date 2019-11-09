package com.demo.servlet;

import com.demo.utils.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class Dispatcher extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LibDaoImpl libDao=new LibDaoImpl();
        if (Objects.equals("/regist",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/regist.jsp").forward(req,resp);
        }
        if (Objects.equals("/login",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req,resp);
        }
        if (Objects.equals("/top",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/top.jsp").forward(req,resp);
        }
        if (Objects.equals("/left",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/left.jsp").forward(req,resp);
        }
        if (Objects.equals("/toCatgoryServlet",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/catgory.jsp").forward(req,resp);
        }
        if (Objects.equals("/ToAddBookServlet",req.getServletPath())){
            req.setAttribute("list",libDao.getBookClassDb());
            req.getRequestDispatcher("WEB-INF/views/addBook.jsp").forward(req,resp);
        }
        if (Objects.equals("/SelectBookServlet",req.getServletPath())){
            req.setAttribute("list",libDao.getBooks());
            req.getRequestDispatcher("WEB-INF/views/showBooks.jsp").forward(req,resp);

        }if (Objects.equals("/search",req.getServletPath())){
            req.setAttribute("list",libDao.getBooksByCondition(req.getParameter("bookID"),req.getParameter("bookName"),req.getParameter("catgoryName")));
            req.setAttribute("id",req.getParameter("bookID"));
            req.setAttribute("name",req.getParameter("bookName"));
            req.setAttribute("catgory",req.getParameter("catgoryName"));
            req.getRequestDispatcher("WEB-INF/views/showBooks.jsp").forward(req,resp);
        }

    }
}
