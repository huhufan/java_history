package com.demo.servlet;

import com.demo.datapro.Course;
import com.demo.datapro.CourseDaoImpl;
import com.demo.datapro.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num,size;
        int end=0;
        List<Course> list = new ArrayList<>();
        if (req.getSession().getAttribute("num")!=null){
            num=(Integer)req.getSession().getAttribute("num");
        }else{
            num=5;
        }
       List<Course> searchList=(List<Course>) req.getSession().getAttribute("searchList");
       if (searchList==null){
           searchList=CourseDaoImpl.getCoursesTable();
       }
        size=searchList.size();
        req.setAttribute("size",size);
        PageUtils pageUtils=new PageUtils(searchList ,num);
        if (Objects.equals("/FirstPage",req.getServletPath())){
            int page=pageUtils.firstPage();
            end=page*num>size?size:page*num;
             list= searchList.subList((page-1)*num,end);
            req.setAttribute("page",page);
        }if (Objects.equals("/FrontPage",req.getServletPath())){
            int curPage=Integer.valueOf(req.getParameter("page"));
            int page=pageUtils.frontPage(curPage);
            end=page*num>size?size:page*num;
            list= searchList.subList((page-1)*num,end);
            req.setAttribute("page",page);
        }if (Objects.equals("/NextPage",req.getServletPath())){
            int curPage=Integer.valueOf(req.getParameter("page"));
            int page=pageUtils.nextPage(curPage);
            end=page*num>size?size:page*num;
            list = searchList.subList((page-1)*num,end);
            req.setAttribute("page",page);
        }if (Objects.equals("/FinPage",req.getServletPath())){
            int page=pageUtils.finPage();
            end=page*num>size?size:page*num;
            list= searchList.subList((page-1)*num,searchList.size());
            req.setAttribute("page",page);
        }
        req.setAttribute("size",size);
        req.setAttribute("end",end);
        req.setAttribute("list", list);

        req.getRequestDispatcher("WEB-INF/views/showCourse.jsp").forward(req,resp);
    }
}
