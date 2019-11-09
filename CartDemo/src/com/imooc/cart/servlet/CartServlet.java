package com.imooc.cart.servlet;

import com.imooc.cart.data.Cart;
import com.imooc.cart.data.LocalCache;
import com.imooc.cart.data.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (Objects.equals("/cart/cart.do",request.getServletPath())){
           String productId=request.getParameter("productId");
           if (null!=productId){
               Product product= LocalCache.getProduct(Long.valueOf(productId));
               LocalCache.addCard(product);
           }
           response.sendRedirect("/cart/list.do");
       } else if (Objects.equals("/cart/delete.do",request.getServletPath())){
           String productId=request.getParameter("productId");
           if (productId!=null){
               LocalCache.delCart(Long.valueOf(productId));
           }
           response.sendRedirect("/cart/list.do");
       }
       else if (Objects.equals("/cart/incr.do",request.getServletPath())){
           String productId=request.getParameter("productId");
           if (productId!=null) {
               LocalCache.incrCart(Long.valueOf(productId));
           }
           response.sendRedirect("/cart/list.do");

       }

       else if (Objects.equals("/cart/decr.do",request.getServletPath())){
               String productId=request.getParameter("productId");
               if (productId!=null) {
                   LocalCache.decrCart(Long.valueOf(productId));
               }
           response.sendRedirect("/cart/list.do");
       }
       else if (Objects.equals("/cart/settlement.do",request.getServletPath())){
           String[] cartIds=request.getParameterValues("carts");
           int totalPrice=0;
           for (int i=0;i<cartIds.length;i++){
               Cart cart=LocalCache.getCart(Long.valueOf(cartIds[i]));
               totalPrice+=cart.getTotalPrice();
               LocalCache.delCart(cart.getId());
           }
           request.setAttribute("totalPrice",totalPrice);
           request.getRequestDispatcher("/WEB-INF/views/biz/settlement.jsp").forward(request,response);

       }

       else if (Objects.equals("/cart/list.do",request.getServletPath())){
           request.setAttribute("carts",LocalCache.getCarts());
           request.getRequestDispatcher("/WEB-INF/views/biz/cart.jsp").forward(request,response);
       }
    }
}
