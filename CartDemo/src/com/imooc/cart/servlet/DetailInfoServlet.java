package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class DetailInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals("/detail/detail.do",req.getServletPath())){
            String productId=req.getParameter("productId");
            if (productId != null) {
                req.setAttribute("product", LocalCache.getProduct(Long.valueOf(productId)));
            }
        }
        req.getRequestDispatcher("/WEB-INF/views/biz/detail.jsp").forward(req,resp);
    }
}
