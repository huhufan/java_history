package com.demo.servlet;

import com.demo.dao.UsersDao;
import com.demo.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private UsersDao usersDao=new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        String nickname = request.getParameter("nickname");
        System.out.println(nickname);
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String emial = request.getParameter("emial");
        String remark = request.getParameter("remark");
        int age2;
        if (age == "") {
            age2=0;
        }else {
            age2 = Integer.parseInt(age);
        }
        Users user=new Users(Integer.parseInt(id),nickname,age2,gender,phone,emial,new Date(),remark);
        usersDao.updateUser(user);
        response.sendRedirect("/detail?id="+id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
