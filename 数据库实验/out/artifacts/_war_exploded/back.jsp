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
    <h1>反馈</h1>
    <form action="/back">
        <table style="text-align: center">
            <tr> <td>标题:</td><td><input type="text"  name="title"></td></tr>
            <tr> <td>反馈内容:</td><td><input type="text"  name="content"></td></tr>
        </table>
        <h3> <input type="submit" value="提交反馈"></h3>
    </form>
</center>
</body>
</html>
