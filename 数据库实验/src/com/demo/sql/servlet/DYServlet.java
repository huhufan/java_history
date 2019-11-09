package com.demo.sql.servlet;

import com.demo.sql.bean.BK;
import com.demo.sql.bean.LW;
import com.demo.sql.bean.YH;
import com.demo.sql.dao.DyDAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


public class DYServlet extends HttpServlet {
     private DyDAO queryDAO = new DyDAO();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        YH user = (YH) req.getSession().getAttribute("user");
        String user_id = user.getId();
        //1、首先获取jsp页面传递过来的参数信息
        if (Objects.equals(req.getServletPath(),"/dy_status")) {
            String zb_id = req.getParameter("zb_id");
            boolean b = queryDAO.getDY_status(zb_id, user_id);
            JSONObject jsonObject = null;
            if (b) {
                jsonObject = new JSONObject("{flag:true}");
            } else {
                jsonObject = new JSONObject("{flag:false}");
            }
            resp.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
        }
        if (Objects.equals(req.getServletPath(),"/sub")){
            String zb_id = req.getParameter("id");
            Boolean c = queryDAO.addDY_status(zb_id, user_id);
            if (c){
                req.getRequestDispatcher("zzlist.do?tip=2").forward(req,resp);
            }

        }
        if (Objects.equals(req.getServletPath(),"/cancel_sub")) {
            String zb_id = req.getParameter("id");
            boolean b = queryDAO.delDY_status(zb_id, user_id);
            if (b) {
                req.getRequestDispatcher("zzlist.do?tip=3").forward(req,resp);
            }
        }
        if (Objects.equals(req.getServletPath(),"/songli")){
            String zb_id = req.getParameter("zzid");
            String num = req.getParameter("num");
            Boolean b = queryDAO.saveLW(zb_id,user_id,num );
            if (b) {
                req.getRequestDispatcher("zzlist.do?tip=1").forward(req,resp);
            }
        }
        if (Objects.equals(req.getServletPath(),"/addTJ")){
            String zb_id = req.getParameter("id");
            boolean b = queryDAO.addTJ(zb_id);
            if (b) {
                req.getRequestDispatcher("/zzMan?tip=3").forward(req,resp);
            }
        }
        if (Objects.equals(req.getServletPath(),"/delTJ")){
            String zb_id = req.getParameter("id");
            boolean b = queryDAO.delTJ(zb_id);
            if (b) {
                req.getRequestDispatcher("/zzMan?tip=3").forward(req,resp);
            }
        }



        }
}
