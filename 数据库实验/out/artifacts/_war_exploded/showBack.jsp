<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/12/12
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>反馈</title>
    <style>
        td{
            padding-right: 50px;
        }
        table{
            padding-top: 80px;
        }
    </style>
</head>
<body>
<center>
    <table style="text-align: center">
        <tr>
            <td>用户名</td><td>反馈标题</td><td>内容</td>
        </tr>
            <c:forEach var="fk" items="${fks}">
                <tr>
                    <td>${fk.uid}</td><td>${fk.title}</td><td>${fk.content}</td>
                </tr>
            </c:forEach>

    </table>
</center>
</body>
</html>
