<%@page language="java" contentType="text/html; charSet=UTF-8" pageEncoding="UTF-8" %>
<% String basePath=(String)session.getAttribute("basePath");%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜名查询</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<h1>菜名查询</h1>
		<form action="<%=basePath%>/SelectServlet" method="post">
			<input type="hidden" name="type" value="2">
			<table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜名</td>
					<td><input type="text" name="foodName"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center"><input type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>