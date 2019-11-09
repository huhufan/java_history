package com.demo.sql.servlet;

import com.demo.sql.bean.BK;
import com.demo.sql.bean.Back;
import com.demo.sql.bean.YH;
import com.demo.sql.bean.ZZ;
import com.demo.sql.common.GetId;
import com.demo.sql.dao.ZZDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserServlet extends HttpServlet {
    private ZZDAO zzdao = new ZZDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        YH user = (YH)req.getSession().getAttribute("user");
        String id ;
        if (Objects.equals(req.getServletPath(),"/updateUser")){
            id = req.getParameter("id");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String sex = req.getParameter("sex");
            String emial = req.getParameter("emial");
            boolean flag = zzdao.UpdateUser(id,username,password,2,sex,emial);
            if (flag){
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }
        }
        id = user.getId();
        if(Objects.equals(req.getServletPath(),"/bec")){
            String username = user.getUsername();
            String title = req.getParameter("title");
            String password = user.getPassword();
            String sex = user.getSex();
            String emial = user .getEmial();
            String url = req.getParameter("url");
            ZZ zz = new ZZ(null,username,title,password,sex,emial,url);
            int a  =zzdao.addZZ(zz);
            if (a>0){
                String zbk_id = req.getParameter("zbk");
                boolean b = zzdao.addzb_zbk(a, Integer.parseInt(zbk_id));
                if (b)
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }

        }
        if (Objects.equals(req.getServletPath(),"/back")){
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int a = zzdao.postBack(new Back(id, title, content));
            if (a>0) {
                boolean b = zzdao.addYH_FK(id, a);
                if (b)
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }

        }
    }
}
