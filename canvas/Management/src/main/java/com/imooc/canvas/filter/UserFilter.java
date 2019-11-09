package com.imooc.canvas.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
     if ("/login.do".equals(((HttpServletRequest)req).getServletPath())||"/loginPrompt".equals(((HttpServletRequest)req).getServletPath())){
        chain.doFilter(req,resp);
        }else if(null != ((HttpServletRequest)req).getSession().getAttribute("username")){
         chain.doFilter(req,resp);
        }else {
         req.getRequestDispatcher("/loginPrompt.do").forward(req,resp);
     }
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
