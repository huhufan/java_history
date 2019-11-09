package com.demo.sql.servlet;

import com.demo.sql.bean.YH;
import com.demo.sql.dao.YHDAO;
import com.demo.sql.dao.ZZDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    private ZZDAO zzdao = new ZZDAO();
    private YHDAO yhdao = new YHDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals(req.getServletPath(),"/login")){
            String username =  req.getParameter("username");
            String password = req.getParameter("password");
            List<YH> list = zzdao.getYHBy_pass(username,password);
        if (list.isEmpty()==true){
            req.setAttribute("error","账号或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
       }
            YH user = list.get(0);
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("server.jsp").forward(req,resp);
        }
        if (Objects.equals(req.getServletPath(),"/regist")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String sex = req.getParameter("sex");
            String emial = req.getParameter("emial");
            YH yh = new YH(null, username, password, 2, sex, emial);
            boolean b1 = yhdao.yh_name_Validate(username);
            boolean b = false;
            if (!b1) {
                 b = yhdao.addYH(yh);
            }
            if (b) {
                req.setAttribute("error","注册成功，请登录");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }else {
                req.setAttribute("error","该用户名已存在，注册失败");
                req.getRequestDispatcher("regist.jsp").forward(req,resp);
            }
        }

        }
}

