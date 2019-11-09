package com.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodeFilter")
public class EncodeFilter implements Filter {
    String code;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(code);
        resp.setCharacterEncoding(code);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
      code=config.getInitParameter("code");
    }

}
