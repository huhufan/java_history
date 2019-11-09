<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/12
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改个人信息</title>
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
    <form action="/updateUser">
    <table style="text-align: center">
        <input type="hidden" value="${user.id}" name="id">
        <tr> <td>用户名:</td><td><input type="text" value="${user.username}" name="username" readonly></td></tr>
        <tr> <td>密码:</td><td><input type="text" value="${user.password}" name="password"></td></tr>
        <tr> <td>性别:</td><td><c:if test="${user.sex eq '男'}">男<input type="radio" name="sex" value="男" checked>女<input type="radio" name="sex" value="女"></c:if><c:if test="${user.sex eq '女'}">男<input type="radio" name="sex" value="男" >女<input type="radio" name="sex" value="女" checked></c:if></td></tr>
        <tr> <td>邮箱:</td><td><input type="text" value="${user.emial}" name="emial"></td></tr>
        <tr> <td></td><td><input type="submit" value="提交更新"></td></tr>
    </table>
    </form>
</center>
</body>
</html>
