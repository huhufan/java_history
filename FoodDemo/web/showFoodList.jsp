<%@ page import="com.imooc.utils.FoodDaoImpl" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.imooc.utils.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="com.imooc.utils.UploadUtils" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath=(String)session.getAttribute("basePath");%>
<% List<Map<String,Food>> foodList=(List)request.getAttribute("foodList");%>
<% String hint="";if (request.getAttribute("hint")!=null){hint=(String)request.getAttribute("hint");}%>
<!DOCTYPE html >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品信息展示</title>
<style type="text/css">
    tr td{
        text-align: center;
    }
</style>
</head>
<body>
	<center>
		<h1>菜品查询</h1>
        <h6 style="color:darkcyan"><%=hint%></h6>
		<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
			<thead>
				<tr>
					<th>菜品ID</th>
					<th>菜名</th>
					<th>口味</th>
					<th>菜品图片</th>
					<th>价格</th>
					<th>菜品描述</th>
				</tr>
			</thead>
			<tbody>
				<%   if (foodList!=null){
					for (Map<String, Food> map:foodList){
				    for (Food food:map.values()){
				%>
				<tr>
					<td><%=food.getId()%></td>
					<td><%=food.getFoodName()%></td>
					<td><%=food.getTaste()%></td>
					<%if(UploadUtils.getURL(food)==null){%>
                        <td style="color: cornflowerblue">该菜品还未添加图片</td><%}else{ %>
                    <td><img width="150px" height="150px" src="/upload/<%=UploadUtils.getURL(food)%>" ></td><%}%>
					<td><%=food.getPrice()%>¥</td>
					<td><%=food.getDescription()%></td>
				</tr>
				<%
					}
					}
					}
				%>
			</tbody>
		</table>
	</center>
</body>
</html>