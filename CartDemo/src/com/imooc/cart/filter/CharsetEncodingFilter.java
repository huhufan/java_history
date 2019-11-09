package com.imooc.cart.filter;

import java.io.IOException;

public class CharsetEncodingFilter implements javax.servlet.Filter {
    private String encode;
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        req.setCharacterEncoding(encode);
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
       this.encode=config.getInitParameter("encode");
    }

}
