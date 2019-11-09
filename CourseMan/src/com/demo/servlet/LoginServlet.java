
package com.demo.servlet;

import com.demo.datapro.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String sessionCode = (String) request.getSession().getAttribute("code");
        System.out.println(sessionCode);
        if (code != null & sessionCode != null) {
            if (code.equalsIgnoreCase(sessionCode)) {
                CourseService service=new CourseService();
                String username=request.getParameter("username");
                String password = request.getParameter("password");
                int a= service.login(username,password);
                if (a==0){
                    request.setAttribute("hint","账号或密码错误");
                    out.write("0");
                }else{
                    if (a==1){
                        request.getSession().setAttribute("flag",1);
                    }if (a==2){
                        request.getSession().setAttribute("flag",2);
                    }
                    request.getSession().setAttribute("username",username);
                    out.write("1");
                }

            } else {
                out.print("fail");
            }
        }

        out.flush();
        out.close();
    }
}

