package com.demo.servlet;

import com.demo.utils.Book;
import com.demo.utils.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book(req.getParameter("id"), req.getParameter("bookName"), req.getParameter("catgoryName"), req.getParameter("price"), req.getParameter("description"));
        new LibDaoImpl().addBook(book);
        resp.sendRedirect("/SelectBookServlet");
    }
}
