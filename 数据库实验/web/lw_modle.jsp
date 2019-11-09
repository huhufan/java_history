<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/12/12
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>礼物详情</title>
    <style>
        td{
            padding-right: 50px;
        }
    </style>
</head>
<body>
<center>
    <table style="text-align: center">
        <tr><td>用户名</td><td>礼物总金额</td></tr>
        <c:forEach items="${LW}" var="lw">
            <tr><td>${lw.id}</td><td>${lw.name}</td></tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
