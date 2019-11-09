package com.imooc.cart.servlet;

import com.imooc.cart.data.LocalCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageStr=request.getParameter("page");
        String name = request.getParameter("title");
        int page=1;
        if (pageStr!=null&&!"".equals(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        List productList=LocalCache.getProducts( page,12,name);
        int totalProduct=LocalCache.getProductsCount(name);
        int totalPage=totalProduct%12>0?totalProduct/12+1:totalProduct/12;
        request.setAttribute("curPage",page);
        request.setAttribute("prePage",page-1>0?page-1:1);
        request.setAttribute("nextPage",page+1>totalPage?totalPage:page+1);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("title",name);

       request.setAttribute("products",productList);
       request.getRequestDispatcher("/WEB-INF/views/biz/list.jsp").forward(request,response);



    }
}
