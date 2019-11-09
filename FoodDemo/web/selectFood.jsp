<%@page language="java" contentType="text/html; charSet=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=session.getAttribute("basepath")%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品查询选项页面</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<p><a href="ShowFoodAll">查询所有菜品信息</a></p>
		<p><a href="selectFoodByName.jsp">菜名查询</a></p>
	</center>
</body>
</html>