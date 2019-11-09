<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<style>
		body{
			margin: 0px;
			padding: 0px;
			background-color: beige;
		}
		a{
			text-decoration: none;
			text-align: center;
			width: 100%;
			color: black;
			font-size: 15px;
			height: 30px;
			line-height: 30px;
			font-family: "微软雅黑";
		}
		div{
			background-color: aliceblue;
			position: absolute;
			top: 50%;
			width: 100%;
			text-align: center;
			height: 200px;
			margin-top: -100px;
		}
	</style>
</head>
<body>
<div>
	<p><a href="addFood.jsp" target="main">菜品添加</a></p>
	<p><a href="selectFood.jsp" target="main">菜品查询</a></p>
	<p><a href="updateFood.jsp" target="main">菜品修改</a></p>
	<p><a href="deleteById.jsp" target="main">菜品删除</a></p>
</div>
</body>
</html>

