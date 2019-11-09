package com.imooc.sm.controller;

import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Staff> list = staffService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response);
    }
    public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DEP",departmentService.getAll());
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String department = request.getParameter("department");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        Date bornTime = null;
        try {
            bornTime = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("bornTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String info = request.getParameter("info");
        Staff staff = new Staff(null,account,"123456","正常",Integer.valueOf(department),name,sex,idNumber,new Date(),null,bornTime,info);
        staffService.add(staff);
        response.sendRedirect("list.do");
    }
    public void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ",staff);
        request.setAttribute("DEP",departmentService.getAll());
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Staff a = staffService.get(id);
        String account = request.getParameter("account");
        String department = request.getParameter("department");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Staff staff= new Staff(id,account,password,a.getStatus(),Integer.valueOf(department),name,sex,idNumber,a.getLeaveTime(),a.getWorkTime(),a.getBornDate(),info);
        staffService.edit(staff);
        response.sendRedirect("list.do");
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }
    public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Staff s = staffService.get(id);
        System.out.println(s.getDepartment().getName());
        request.setAttribute("OBJ",s);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);

    }
}
