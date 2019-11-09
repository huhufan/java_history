package com.demo.filter;

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
        if (!requestURI.equals("/login")&& !requestURI.equals("/regist")&&!requestURI.equals("/")&&!requestURI.equals("/RegistServlet")&&!requestURI.equals("/LoginServlet")) {
            if (((HttpServletRequest) req).getSession().getAttribute("username") == null) {
                req.getRequestDispatcher("/WEB-INF/views/tip.jsp").forward(request, response);
            }
        }
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
