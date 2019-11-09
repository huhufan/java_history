package com.imooc.canvas.servlet;

import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.entity.Category;
import com.imooc.canvas.service.CanvasService;
import com.imooc.canvas.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CanvasServlet extends HttpServlet {
    private CanvasService canvasService;
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        categoryService = new CategoryService();
        canvasService = new CanvasService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/canvas/list.do".equals(req.getServletPath())) {
            String pageStr = req.getParameter("page");
            String categoryIdStr = req.getParameter("categoryId");
            try {
                Long categoryId = 0L;
                if (null != categoryIdStr && !"".equals(categoryIdStr.trim())) {
                    categoryId = Long.valueOf(categoryIdStr);
                }
                int page = 1;
                if (null != pageStr && !"".equals(pageStr.trim())) {
                    page = Integer.valueOf(pageStr);
                }
                List<Canvas> canvas = null;
                int count = 0;
                int last = 0;
                if (categoryId != 0l) {
                    canvas = canvasService.getCanvasViewByCategoryId(categoryId, (page - 1) * 3, 3);
                    count = canvasService.countCanvasByCategoryId(categoryId);
                    last = count % 3 == 0 ? (count / 3) : ((count / 3) + 1);
                }
                if (categoryId == 0l) {
                    canvas = canvasService.getCanvasView((page - 1) * 3, 3);
                    count = canvasService.countCanvas();
                    last = count % 3 == 0 ? (count / 3) : ((count / 3) + 1);
                }
                List<Category> categories = categoryService.getCategories();
                //将数据存储到req作用域中
                req.setAttribute("canvas", canvas);
                req.setAttribute("categories", categories);
                req.setAttribute("page", page);
                req.setAttribute("last", last);
                req.setAttribute("categoryId", categoryId);
                req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
                req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
            }
        }else if ("/canvas/smallImg.do".equals(req.getServletPath())) {
            String idStr = req.getParameter("id");
            Canvas canvas = canvasService.getImgById(Long.valueOf(idStr));
            try {
                resp.setContentType("multipart/form-data");
                if (null != canvas && null != canvas.getSmallImg()) {
                    InputStream in = new ByteArrayInputStream(canvas.getSmallImg());
                    ServletOutputStream out = resp.getOutputStream();
                    byte[] b = new byte[1024];
                    int length = in.read(b);
                    while (length != -1) {
                        out.write(b);
                        length = in.read(b);
                    }
                    out.flush();
                    out.close();
                    in.close();
                    resp.flushBuffer();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("/canvas/details.do".equals(req.getServletPath())) {
            String idStr = req.getParameter("id");
            Canvas canvas = canvasService.getCanvasByID(Long.valueOf(idStr));
            req.setAttribute("canvas",canvas);
            req.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(req,resp);
        }

    }


    @Override
    public void destroy() {
        super.destroy();
        canvasService = null;
        categoryService = null;
    }


}
