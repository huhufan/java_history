<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/12
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <style>
        tr{
            height: 40px;
            width: 400px;
        }
        span{
            margin-left: 20px;
            margin-right: 20px;
        }
    </style>
</head>
<body>
<center>
    <div style="padding-bottom: 20px;padding-top: 20px"><a href="login.jsp">登录<span>|</span></a><a href="regist.jsp">注册</a></div>
        <form action="/regist">
            <table style="text-align: center">
                <tr><td>用户名</td><td><input type="text" name="username" placeholder="${error}"></td></tr>
                <tr><td>密码</td><td><input type="password" name="password"></td></tr>
                <tr><td>性别</td><td>男<input type="radio" name="sex" value="男" checked>女<input type="radio" name="sex" value="女"></td></tr>
                <tr><td>Email</td><td><input type="password" name="emial"></td></tr>
                <tr><td></td><td><input type="submit" value="注册"></td></tr>
       </table>
        </form>
</center>
</body>
</html>
