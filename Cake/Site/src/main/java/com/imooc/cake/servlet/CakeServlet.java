package com.imooc.cake.servlet;

import com.imooc.cake.entity.Cake;
import com.imooc.cake.entity.Category;
import com.imooc.cake.service.CakeService;
import com.imooc.cake.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * 网站servlet
 *
 * @version 1.0
 */
public class CakeServlet extends HttpServlet {

    private CakeService cakeService;

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        cakeService = new CakeService();
        categoryService = new CategoryService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/cake/list.do".equals(req.getServletPath())) {
            //获取request请求中的当前页数
            String pageStr = req.getParameter("page");
            //获取request请求中的分类id
            String categoryIdStr = req.getParameter("categoryId");
            try {
                //设置默认分类id为1
                Long categoryId = 1L;
                //如果categoryIdStr不为null并且不为空字符串，这里的trim方法是用来清除字符串中的多余符号用的，譬如空格等
                if (null != categoryIdStr && !"".equals(categoryIdStr.trim())) {
                    //将categoryIdStr的值转换为长整型的数据并赋值给categoryId
                    categoryId = Long.valueOf(categoryIdStr);
                }
                //设置page的默认值
                int page = 1;
                //如果pageStr不为null并且不为空字符串
                if (null != pageStr && !"".equals(pageStr.trim())) {
                    page = Integer.valueOf(pageStr);
                }
                List<Cake> cakes = cakeService.getCakesByCategoryId(categoryId, page, 8);
                //定义整型变脸count，用来接收countCakesByCategoryId返回当前分类Id下的蛋糕总数
                int count = cakeService.countCakesByCategoryId(categoryId);
                //通过计算获取最后一页的页数
                int last = count % 8 == 0 ? (count / 8) : ((count / 8) + 1);
                //通过getCateegories方法可以获取所有蛋糕分类
                List<Category> categories = categoryService.getCateegories();
                //将数据存储到req作用域中
                req.setAttribute("cakes", cakes);
                req.setAttribute("categories", categories);
                req.setAttribute("page", page);
                req.setAttribute("last", last);
                req.setAttribute("categoryId", categoryId);
                //转发到index.jsp页面
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
            }
        } else if ("/cake/getImg.do".equals(req.getServletPath())) {
            //获取蛋糕的id
            String idStr = req.getParameter("id");
            //通过getCakeImg获取只包含图片的cake实体类
            Cake cake = cakeService.getCakeImg(Long.valueOf(idStr));
            try {
                //设置response回传的数据类型可以传递二进制
                resp.setContentType("multipart/form-data");
                //如果cake不为null，并且getSmallImg()获取的属性不为null
                if (null != cake && null != cake.getSmallImg()) {
                    //创建输入流对象，读取二进制图片数据
                    InputStream in = new ByteArrayInputStream(cake.getSmallImg());
                    //创建输出流用来输出图片
                    ServletOutputStream out = resp.getOutputStream();
                    //创建byte类型的数组
                    byte[] b = new byte[1024];
                    //获取读取字节的长度
                    int length = in.read(b);
                    while (length != -1) {
                        //向输出流中写入数据
                        out.write(b);
                        length = in.read(b);
                    }
                    //强制刷新内存
                    out.flush();
                    //关闭输出流
                    out.close();
                    //关闭输入流
                    in.close();
                    //将Buffer中的所有数据清空
                    resp.flushBuffer();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        cakeService = null;
        categoryService = null;
    }
}
