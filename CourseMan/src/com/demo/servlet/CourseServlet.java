package com.demo.servlet;

import com.demo.datapro.Course;
import com.demo.datapro.CourseDaoImpl;
import com.demo.datapro.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService service=new CourseService();
        if (Objects.equals("/addCourse",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/addCourse.jsp").forward(req ,resp);
        }
        if (Objects.equals("/courseImport",req.getServletPath())){
            req.getRequestDispatcher("WEB-INF/views/courseImport.jsp").forward(req ,resp);
        }
        if (Objects.equals("/ExportCourseServlet",req.getServletPath())){

        }if (Objects.equals("/GetCourseServlet",req.getServletPath())){
                req.getSession().setAttribute("searchList",null);
                req.getSession().setAttribute("search_val","");
                req.getSession().setAttribute("num",5);
            req.getRequestDispatcher("/FirstPage").forward(req ,resp);
        }if (Objects.equals("/AddCourseServlet",req.getServletPath())){
            if (req.getParameter("courseId").equals("") || req.getParameter("courseName").equals("")) {
                req.setAttribute("hint","课程Id和课程名不能为空");
                req.getRequestDispatcher("WEB-INF/views/addCourse.jsp").forward(req,resp);
                return;
            }
            Course course = new Course(req.getParameter("courseId"),req.getParameter("courseName"),req.getParameter("coursePath"),
                    req.getParameter("courseDes"),req.getParameter("courseDuration"),(String)req.getSession().getAttribute("username"));
            CourseDaoImpl.getCoursesTable().add(course);
            resp.sendRedirect("/GetCourseServlet");

        }if (Objects.equals("/SearchCourse",req.getServletPath())){
             int num=Integer.valueOf(req.getParameter("num"));
             req.getSession().setAttribute("num",num);
             String s=req.getParameter("searchChar");
             if (!s.equals("")){
                 List<Course> searchList=service.searchCourse(s);
                 req.getSession().setAttribute("search_val",s);
                 req.getSession().setAttribute("searchList",searchList);
             }
             if (s.equals("")){
                 req.getSession().setAttribute("search_val","");
                 req.getSession().setAttribute("searchList",null);
            }
            req.getRequestDispatcher("/FirstPage").forward(req ,resp);
        }
    }
}
