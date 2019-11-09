package com.demo.sql.servlet;


import com.demo.sql.bean.BK;
import com.demo.sql.bean.Back;
import com.demo.sql.bean.YH;
import com.demo.sql.bean.ZZ;
import com.demo.sql.dao.DyDAO;
import com.demo.sql.dao.YHDAO;
import com.demo.sql.dao.ZZDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ManageServlet extends HttpServlet {
    private ZZDAO zzdao = new ZZDAO();
    private YHDAO yhdao = new YHDAO();
    private DyDAO dyDAO = new DyDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals(req.getServletPath(), "/userMan")) {
            List<YH> user = yhdao.getYH();
            req.setAttribute("users", user);
            req.getRequestDispatcher("showYH.jsp").forward(req, resp);
        }
        if (Objects.equals(req.getServletPath(), "/getLW")) {
            String id = req.getParameter("id");
            List<BK> lw_modle = dyDAO.getLW_modle(id);
            req.setAttribute("LW",lw_modle);
            req.getRequestDispatcher("lw_modle.jsp").forward(req,resp);
        }

            if (Objects.equals(req.getServletPath(), "/lookDetail")) {
            String id = req.getParameter("id");
            List<YH> users = zzdao.getYHBy_id(id);
            if (!users.isEmpty()) {
                YH user = users.get(0);
            }
            YH user = users.get(0);
            System.out.println(user.getUsername());
            req.setAttribute("users", user);
            req.getRequestDispatcher("lookDetail.jsp").forward(req, resp);
        }
        if (Objects.equals(req.getServletPath(), "/manUpdate")) {
            String id = req.getParameter("id");
            List<YH> users = zzdao.getYHBy_id(id);
            if (!users.isEmpty()) {
                YH user = users.get(0);
            }
            YH user = users.get(0);
            System.out.println(user.getUsername());
            req.setAttribute("user", user);
            req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
        }

        if (Objects.equals(req.getServletPath(), "/manDelete")) {
            String id = req.getParameter("id");
            if(zzdao.deleteUser(id)){
                req.setAttribute("tip","删除成功");
                req.getRequestDispatcher("userMan").forward(req,resp);
            }
        }
        if (Objects.equals(req.getServletPath(),"/zzMan")){
            String tip = req.getParameter("tip");
            if (tip!=null) {
                if (tip.equals("1")) {
                    req.setAttribute("tip", "删除成功");
                }
                if (tip.equals("2")) {
                    req.setAttribute("tip", "修改信息成功");
                }
                if (tip.equals("3")) {
                    req.setAttribute("tip", "修改推荐状态成功");
                }
            }
            List<ZZ> anchor = zzdao.getAnchor();
            req.setAttribute("zzs",anchor);
            req.getRequestDispatcher("zzlist.jsp").forward(req,resp);
        }
        if (Objects.equals(req.getServletPath(),"/zzdelete")){
            String id = req.getParameter("id");
            System.out.println(id);
            if(zzdao.deletezz(id)){
                req.getRequestDispatcher("/zzMan?tip=1").forward(req,resp);
            }
        }
        if (Objects.equals(req.getServletPath(),"/zzupdate")){
            String id = req.getParameter("id");
            List<ZZ> zzList = zzdao.getZZbyId(id);
            ZZ zz = zzList.get(0);
            req.setAttribute("zz",zz);
            req.getRequestDispatcher("zzUpdate.jsp").forward(req,resp);
        }
        if (Objects.equals(req.getServletPath(),"/updatezz")){
            String id = req.getParameter("id");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String title = req.getParameter("title");
            String sex = req.getParameter("sex");
            String emial = req.getParameter("emial");
            if (zzdao.updatezz(id,username,password,title,sex,emial))
                req.getRequestDispatcher("/zzMan?tip=2").forward(req,resp);
        }
        if (Objects.equals(req.getServletPath(),"/banMan")){
            List<Back> fk = dyDAO.getFK();
            req.setAttribute("fks",fk);
            req.getRequestDispatcher("showBack.jsp").forward(req,resp);
        }
        }
}
