package com.imooc.canvas.servlet;

import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.entity.Category;
import com.imooc.canvas.service.CanvasService;
import com.imooc.canvas.service.CategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class CanvasServlet extends HttpServlet {
    private CanvasService canvasService;
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        super.init();
        canvasService = new CanvasService();
        categoryService = new CategoryService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/canvas/list.do".equals(req.getServletPath())) {
            String categoryId = req.getParameter("categoryId");
            List<Canvas> canvas = null;
            try {
                Long category = null;
                if (null != categoryId) {
                    category = Long.valueOf(categoryId);
                    canvas = canvasService.getCanvasById(category);
                } else {
                    canvas = canvasService.getCanvas();
                }
                req.setAttribute("canvas", canvas);
                List<Category> categories = categoryService.getCategories();
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/WEB-INF/view/biz/canvas_list.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
                req.getRequestDispatcher("/WEB-INF/view/biz/canvas_list.jsp").forward(req, resp);
            }
        } else if ("/canvas/delete.do".equals(req.getServletPath())) {
            String id = req.getParameter("id");
            Long categoryId = Long.valueOf(id);
            canvasService.delCanvas(categoryId);
            resp.sendRedirect("/canvas/list.do");
        } else if ("/canvas/updatePrompt.do".equals(req.getServletPath())) {
            String id = req.getParameter("id");
            Long canvasId = Long.valueOf(id);
            Canvas canvas = canvasService.getCanvasByID(canvasId);
            req.setAttribute("canvas", canvas);
            List<Category> categories = categoryService.getCategories();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/view/biz/update_canvas.jsp").forward(req, resp);
        } else if ("/canvas/update.do".equals(req.getServletPath())) {
            if (ServletFileUpload.isMultipartContent(req)) {
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List<FileItem> items = upload.parseRequest(req);
                    Iterator<FileItem> ite = items.iterator();
                    Canvas canvas = new Canvas();
                    while (ite.hasNext()) {
                        FileItem item = ite.next();
                        if (item.isFormField()) {
                            String fieldName = item.getFieldName();
                            if ("id".equals(fieldName)) {
                                canvas.setId(Long.valueOf(item.getString()));
                            } else if ("name".equals(fieldName)) {
                                canvas.setName(new String(item.getString().getBytes("iso8859-1"), "utf-8"));
                            } else if ("categoryId".equals(fieldName)) {
                                canvas.setCategoryId(Long.valueOf(item.getString()));
                            } else if ("description".equals(fieldName)) {
                                canvas.setDescription(new String(item.getString().getBytes("iso8859-1"), "utf-8"));
                            } else if ("price".equals(fieldName)) {
                                canvas.setPrice(Integer.valueOf(item.getString()));
                            }
                        } else {
                            canvas.setSmallImg(item.get());
                        }
                    }
                    canvasService.updateCanvas(canvas);
                    resp.sendRedirect("/canvas/list.do");
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }
        } else if ("/canvas/addPrompt.do".equals(req.getServletPath())) {
            List<Category> categories = categoryService.getCategories();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/view/biz/add_canvas.jsp").forward(req, resp);
        } else if ("/canvas/add.do".equals(req.getServletPath())) {
            if (ServletFileUpload.isMultipartContent(req)) {
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List<FileItem> items = upload.parseRequest(req);
                    Iterator<FileItem> ite = items.iterator();
                    Canvas canvas = new Canvas();
                    String creator = (String) req.getSession().getAttribute("username");
                    canvas.setCreator(creator);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    canvas.setCreateTime(timestamp);
                    while (ite.hasNext()) {
                        FileItem item = ite.next();
                        if (item.isFormField()) {
                            String fieldName = item.getFieldName();
                            if ("id".equals(fieldName)) {
                                canvas.setId(Long.valueOf(item.getString()));
                            } else if ("name".equals(fieldName)) {
                                canvas.setName(new String(item.getString().getBytes("iso8859-1"), "utf-8"));
                            } else if ("categoryId".equals(fieldName)) {
                                canvas.setCategoryId(Long.valueOf(item.getString()));
                            } else if ("description".equals(fieldName)) {
                                canvas.setDescription(new String(item.getString().getBytes("iso8859-1"), "utf-8"));
                            } else if ("price".equals(fieldName)) {
                                canvas.setPrice(Integer.valueOf(item.getString()));
                            }
                        } else {
                            canvas.setSmallImg(item.get());
                        }
                    }
                    canvasService.addCanvas(canvas);
                    resp.sendRedirect("/canvas/list.do");
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        canvasService = null;
        categoryService = null;
    }
}
