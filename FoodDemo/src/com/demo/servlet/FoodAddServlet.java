package com.demo.servlet;

import com.imooc.utils.Food;
import com.imooc.utils.FoodDaoImpl;
import com.imooc.utils.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Map<String,String> map=new HashMap<>();
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> fileItems=upload.parseRequest(req);
            for (FileItem fileItem:fileItems) {
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    map.put(name, value);
                } else {
                    String fileName = fileItem.getName();
                    System.out.println(fileName);
                    if (fileName != null && !"".equals(fileName)) {
                        String UUID = UploadUtils.getUUID(fileName);
                        String path = this.getServletContext().getRealPath("/upload");
                        InputStream is = fileItem.getInputStream();
                        String foodImage = path + "\\" + UUID;
                        map.put("foodImage", foodImage);
                        OutputStream os = new FileOutputStream(foodImage);
                        int len = 0;
                        byte[] b = new byte[1024];
                        while ((len = is.read(b)) != -1) {
                            os.write(b, 0, len);
                        }
                        is.close();
                        os.flush();
                        os.close();

                    }
                }
            }
            double price=map.get("price").equals("")?0.00:Double.valueOf(map.get("price"));
            Food food = new Food(map.get("id"),map.get("foodName"),map.get("taste"),map.get("foodImage"),price,map.get("description"));
            if (food.getId().equals("")||food.getFoodName().equals("")){
                req.setAttribute("hint","菜名ID或菜名为空，请重新添加");
                req.getRequestDispatcher("/addFood.jsp").forward(req,resp);
                return;
            }
            if (map.get("update")==null) {
                if (FoodDaoImpl.getFoodById(map.get("id")) != null) {
                    req.setAttribute("hint", "该菜品ID已存在，请重新添加");
                    req.getRequestDispatcher("/addFood.jsp").forward(req, resp);
                    return;
                }
            }else{
                if (FoodDaoImpl.getFoodById(map.get("id")) == null){
                    req.setAttribute("hint","菜品栏中没有该商品，已将该新菜品添加至菜品栏");
                }else {
                    req.setAttribute("hint", "菜品修改成功");
                }
            }
            Map<String ,Food> mapee=new HashMap<>();
            mapee.put(map.get("id"),food);
            FoodDaoImpl.updateFood(mapee);
            req.getRequestDispatcher("/ShowFoodAll").forward(req,resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
