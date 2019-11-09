package com.test.servlet;

import com.sun.deploy.util.StringUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import sun.awt.image.JPEGImageDecoder;
import sun.misc.IOUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.stream.Stream;

import static com.sun.imageio.plugins.jpeg.JPEG.JPG;


public class MyServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.addCookie(new Cookie("hello","123"));
        request.getRequestDispatcher("return.jsp").forward(request,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }

    @Override
    public ServletContext getServletContext() {
        return super.getServletContext();
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public String getServletName() {
        return super.getServletName();
    }
}
