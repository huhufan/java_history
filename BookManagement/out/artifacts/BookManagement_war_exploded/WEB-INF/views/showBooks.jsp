
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-1.4.2.js"></script>
</head>
<body>
<center>
	<h1>图书查询</h1>
	<p>
	<form action="<%=basePath%>/search" method="post">
		图书ID：<input type="text" name="bookID" placeholder="${id}">
		图书名：<input type="text" name="bookName" placeholder="${name}">
		分类：<input type="text" name="catgoryName" placeholder="${catgory}">
		<input type="submit" value="查询" id="search">
	</form>
	</p>
	<hr>
	<table style="text-align: center" width="800px" cellspacing="0px" cellpadding="0px" border="1px">
		<thead>
		<tr>
			<th>图书ID</th>
			<th>书名</th>
			<th>分类</th>
			<th>价格</th>
			<th>描述</th>
		</tr>
		</thead>
		<tbody id="cont">
		<c:forEach items="${list}" var="Book">
			<tr>
				<td>${Book.bookId}</td>
				<td>${Book.bookName}</td>
				<td>${Book.bookClass}</td>
				<td>${Book.price}</td>
				<td>${Book.des}</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	</p></center>
	
</body>
</html>