<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath=(String)session.getAttribute("basePath");%><!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品删除(根据ID删)</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<h1>菜品删除(根据ID删除)</h1>
		<form action="<%=basePath%>/FoodDeleteServlet" method="post">
			<table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜品ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center"><input type="submit" value="删除"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>