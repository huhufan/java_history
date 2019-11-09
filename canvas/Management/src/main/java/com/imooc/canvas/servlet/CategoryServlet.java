package com.imooc.canvas.servlet;

import com.imooc.canvas.entity.Category;
import com.imooc.canvas.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryService = new CategoryService();

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/category/list.do".equals(req.getServletPath())) {
            List<Category> categories = categoryService.getCategories();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/view/biz/category_list.jsp").forward(req, resp);
        }
        else if ("/category/delete.do".equals(req.getServletPath())) {
            String id = req.getParameter("id");
            Long categoryId = Long.valueOf(id);
            categoryService.delCategory(categoryId);
            resp.sendRedirect("/category/list.do");
        }
        else if ("/category/updatePrompt.do".equals(req.getServletPath())) {
            String id = req.getParameter("id");
            Long categoryId = Long.valueOf(id);
            Category category = categoryService.getCategoryById(categoryId);
            req.setAttribute("category",category);
            req.getRequestDispatcher("/WEB-INF/view/biz/update_category.jsp").forward(req, resp);
            }
        else if ("/category/update.do".equals(req.getServletPath())) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            categoryService.updateCategory(new Category(Long.valueOf(id),name,description));
            resp.sendRedirect("/category/list.do");
        }
        else if ("/category/addPrompt.do".equals(req.getServletPath())) {
            req.getRequestDispatcher("/WEB-INF/view/biz/add_category.jsp").forward(req, resp);
        }
        else if ("/category/add.do".equals(req.getServletPath())) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String creator =(String)req.getSession().getAttribute("username");
            categoryService.addCategory(new Category(name,creator,description));
            resp.sendRedirect("/category/list.do");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        categoryService = null;
    }
}


