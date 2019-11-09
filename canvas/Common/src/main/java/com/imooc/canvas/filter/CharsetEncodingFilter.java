package com.imooc.canvas.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符集的过滤器
 */

public class CharsetEncodingFilter implements Filter{
    private String encoding;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
          servletRequest.setCharacterEncoding(encoding);
          servletResponse.setCharacterEncoding(encoding);
          filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
