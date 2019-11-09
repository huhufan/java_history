package com.imooc.servlet;

import com.imooc.dao.DepartmentDao;
import com.imooc.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {
    @Autowired
    DepartmentDao departmentDao;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> all = departmentDao.getAll();
        System.out.println(all);
    }
}
