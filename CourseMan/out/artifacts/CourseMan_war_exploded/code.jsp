<%@ page import="com.demo.cartutils.CaptcahCode" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/8/3
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //清空浏览器缓存
    response.setHeader("paragma","no-cache");
    response.setHeader("cache-comtrol","no-cache");
    response.setHeader("expires","0");
    //调用编写的生成验证码的工具
    String code = CaptcahCode.drawImage( response);
    session.setAttribute("code",code);
    //如果解决getOutputStream的异常问题

%>