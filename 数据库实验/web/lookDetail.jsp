<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/12
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
    <style>
        tr{
            width: 100px;
            height: 40px;
            font-size: 20px;
        }
        .con{
            color: darkcyan;
        }
    </style>
</head>
<body>
<center>
    <table style="text-align: center">
       <tr> <td>用户名:</td><td class="con">${requestScope.users.username}</td></tr>
        <tr> <td>用户权限:</td><c:if test="${requestScope.users.usersign eq 2}"><td class="con">普通用户</td></c:if><c:if test="${requestScope.users.usersign eq 1}"><td class="con">管理员</td></c:if></tr>
        <tr> <td>性别:</td><td class="con">${requestScope.users.sex}</td></tr>
        <tr> <td>邮箱:</td><td class="con">${requestScope.users.emial}</td></tr>
    </table>
</center>
</body>
</html>
