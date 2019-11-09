package com.demo.sql.servlet;

import com.demo.sql.bean.BK;
import com.demo.sql.bean.LW;
import com.demo.sql.bean.YH;
import com.demo.sql.dao.ZZDAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "JspServlet")
public class JspServlet extends HttpServlet {
    private ZZDAO zzdao = new ZZDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals(req.getServletPath(), "/JspServlet")) {
            List<BK> bklist = zzdao.getPlate();
            req.setAttribute("bklist", bklist);
            req.getRequestDispatcher("selectBK.jsp").forward(req, resp);
        }
        if (Objects.equals(req.getServletPath(),"/zbk")){
            String bk = req.getParameter("bk");
            List<BK> zbklist = zzdao.getZiPlate(bk);
            req.setAttribute("zbk",zbklist);
            req.getRequestDispatcher("bec.jsp").forward(req ,resp);
        }



    }
}
