package com.demo.sql.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        if (!requestURI.equals("/login.jsp")&& !requestURI.equals("/regist.jsp")&&!requestURI.equals("/")&&!requestURI.equals("/regist")&&!requestURI.equals("/l" +
                "" +
                "ogin")) {
            if (((HttpServletRequest) req).getSession().getAttribute("user") == null) {
                req.getRequestDispatcher("tip.jsp").forward(request, response);
            }
        }
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
