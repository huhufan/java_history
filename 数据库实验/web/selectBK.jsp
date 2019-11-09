<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/13
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<CENTER>
    <form action="/zbk">
        <h3>请选择您要直播的板块
           <select name="bk"><c:forEach var="bk" items="${bklist}"><c:if test="${bk.id ne 'BK000'}"><option value="${bk.id}">${bk.name}</option></c:if></c:forEach></select>
        </h3>
        <h3><input type="submit" value="提交选择"></h3>
    </form>
</CENTER>
</body>
</html>
