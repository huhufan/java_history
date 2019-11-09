package com.imooc.sso.filter;

import sun.security.krb5.internal.Ticket;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    private String server;
    private String app;
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String ticket = null;
        if (((HttpServletRequest)request).getCookies() != null)     {
            for (Cookie cookie : ((HttpServletRequest)request).getCookies()) {
                if (Objects.equals(cookie.getName(), "Ticket_Granting_Ticket")) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }
        if (!Objects.equals(null, ticket)){
            chain.doFilter(request, response);
            return;
        }
             ticket =request.getParameter("ticket");
        if (!Objects.equals(null,ticket) && !Objects.equals(ticket.trim(),"")){
            ((HttpServletResponse)response).addCookie(new Cookie("Ticket_Granting_Ticket",ticket));
            chain.doFilter(request,response);
        }else{
            ((HttpServletResponse)response).sendRedirect(server+"/ssoLogin?source="+app);
        }
    }
    public void init(FilterConfig config) throws ServletException {
        server=config.getInitParameter("server");
        app=config.getInitParameter("app");

    }

}
