package com.demo.servlet;

import com.imooc.utils.Food;
import com.imooc.utils.FoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setCharacterEncoding("utf-8");
        if (Objects.equals(req.getServletPath(), "/ShowFoodAll")) {
            if (FoodDaoImpl.getAllFood().isEmpty()){
                req.setAttribute("hint","菜品栏为空，快去添加菜品吧");
            }
            req.setAttribute("foodList", FoodDaoImpl.getAllFood());
        }
        if (Objects.equals(req.getServletPath(), "/SelectServlet")) {
            String foodName = req.getParameter("foodName");
            List<Map<String, Food>> list = FoodDaoImpl.getFoodByName(foodName);
            if (FoodDaoImpl.getFoodByName(foodName).isEmpty()){
                req.setAttribute("hint","抱歉，没有找到该菜品哦");
            }
            req.setAttribute("foodList", list);
        }
        if (Objects.equals(req.getServletPath(), "/FoodDeleteServlet")){
            String id=req.getParameter("id");
            boolean flag=FoodDaoImpl.deleteFoodById(id);
            if (!flag){
                req.setAttribute("hint","菜品栏中没有该商品，无需删除");
            }else{
                req.setAttribute("hint","已成功删除该菜品");

            }
            req.setAttribute("foodList", FoodDaoImpl.getAllFood());
        }
            req.getRequestDispatcher("/showFoodList.jsp").forward(req, resp);
        }
    }

