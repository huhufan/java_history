<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/14
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>礼物清单</title>
</head>
<body>
<center>
<h1>礼物清单</h1>
<table style="text-align: center">
    <tr><td>用户编号</td><td>用户名</td><td>金额</td></tr>
    <c:forEach var="lw" items="${LW}">
        <tr><td>${lw.zz_id}</td><td>${lw.user_id}</td><td>${lw.money}</td></tr>
    </c:forEach>
</table>
</center>
</body>
</html>
