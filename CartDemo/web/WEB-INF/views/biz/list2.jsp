<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/8/23
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hahaha
<c:forEach items="${products}" var="product">
<P>1</P>
    <h3>${product.name}-${product.id}</h3>

</c:forEach>
</body>
</html>
