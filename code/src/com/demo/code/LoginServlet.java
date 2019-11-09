
package com.demo.code;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();//*******
        String code = request.getParameter("code");
        System.out.println(code);
        String sessionCode = (String)request.getSession().getAttribute("kcode");
        System.out.println(sessionCode);
        if (code != null & sessionCode != null) {
            if (code.equalsIgnoreCase(sessionCode)) {
                out.print("success");//*******
            } else {
                out.print("fail");
            }
        }

        out.flush();
        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
