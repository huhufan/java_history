package com.demo.servlet;

import com.demo.dao.UsersDao;
import com.demo.entity.Users;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addUser")
public class addUserServlet extends HttpServlet {
    private UsersDao usersDao=new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        String userpass = request.getParameter("userpass");
        String nickname = request.getParameter("nickname");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String emial = request.getParameter("emial");
        String remark = request.getParameter("remark");
        Users users =new Users(username,userpass,nickname,Integer.parseInt(age),gender,phone,emial,new Date(),new Date(),new Date(),0,remark);
        Users user=usersDao.addUsers(users);
        response.sendRedirect("/detail?id="+user.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
