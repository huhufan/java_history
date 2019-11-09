package com.demo.sql.servlet;

import com.demo.sql.bean.BK;
import com.demo.sql.bean.YH;
import com.demo.sql.bean.ZZ;
import com.demo.sql.dao.ZZDAO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AnchorServlet extends HttpServlet {
    private ZZDAO zzdao=new ZZDAO();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bkid=req.getParameter("bkid");
        if (bkid != null) {
            req.getSession().setAttribute("zbkid",null);
            req.getSession().setAttribute("bkid",bkid);
            if (!bkid.equals("DY")&!bkid.equals("TJ")){
                List zbklist = zzdao.getZiPlate(bkid);
                req.getSession().setAttribute("zbklist",zbklist);
            }
        }
        String zbkid=req.getParameter("zbkid");
        if (zbkid != null){
            req.getSession().setAttribute("zbkid",zbkid);
        }
        List<BK> bkList = zzdao.getPlate();
        req.setAttribute("bklist",bkList);
        List<ZZ> zzlist = null;
        bkid = (String)req.getSession().getAttribute("bkid");
        zbkid = (String)req.getSession().getAttribute("zbkid");

        if (bkid == null & zbkid == null){
                zzlist =zzdao.getAnchor();
            }
        if (bkid != null) {
            if (!bkid.equals("DY")&!bkid.equals("TJ")){
                if (bkid != null & zbkid == null){
                    zzlist =zzdao.getAnchorBybk(bkid);
                }
                if (bkid != null & zbkid != null){
                    zzlist =zzdao.getAnchorByzbk(zbkid);
                }
            }
            if (bkid.equals("TJ")) {
                zzlist = zzdao.getAnchorTJ();
                req.getSession().setAttribute("zbklist",null);
            }
            if (bkid.equals("DY")) {
                YH zz = (YH) req.getSession().getAttribute("user");
                String id = zz.getId();
                zzlist = zzdao.getAnchorDY(id);
                req.getSession().setAttribute("zbklist",null);
            }
        }
         String tip = req.getParameter("tip");
         if (tip!=null){
               if (tip.equals("1")){
                   req.setAttribute("warn","礼物赠送成功");
               }
               if (tip.equals("2")){
                   req.setAttribute("warn","关注成功");
               }
             if (tip.equals("3")){
                 req.setAttribute("warn","取消订阅成功");
             }
         }
        req.setAttribute("zzlist",zzlist);
        req.getRequestDispatcher("/show.jsp").forward(req,resp);
    }
}
