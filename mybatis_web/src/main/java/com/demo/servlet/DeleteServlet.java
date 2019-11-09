package com.demo.servlet;

import com.demo.dao.UsersDao;
import com.demo.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    UsersDao usersDao=new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id=request.getParameter("id");
         String type=request.getParameter("type");
         if (type.equals("lock")){
             Users user =new Users();
             user.setUserStatus(1);
             user.setId(Integer.parseInt(id));
             usersDao.updateUser(user);
         }if (type.equals("unlock")){
            Users user =new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(0);
            usersDao.updateUser(user);
        } if (type.equals("delete")){
            usersDao.deleteUser(Integer.parseInt(id));
        }
        response.sendRedirect("index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   this.doPost(request,response);
    }
}
