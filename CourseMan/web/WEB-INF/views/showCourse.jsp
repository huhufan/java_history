<%@page language="java" contentType="text/html; charSet=UTF-8"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="<%=basePath%>">
	<style>
		.menu{
			padding-top: 20px;
			overflow: hidden;
		}
		.page form{
			float: left;
			padding-left: 20px;
		}
		.page_des{
			background-color: lightgray;
		}
		.page_des span{
			text-align: center;
			background-color:darkgray;
		}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程查询</title>
<!-- 分页查看 -->
<link rel="stylesheet" type="text/css" href="resources/js/dataTable/jquery.dataTables.min.css">
<script type="text/javascript" src="resources/js/dataTable/jquery.js"></script>
<script type="text/javascript" src="resources/js/dataTable/jquery.dataTables.min.js"></script>
</head>
<body>
	<center>
		<h1>课程查询</h1>
		<hr>
		<form style="margin-top: 5px;margin-bottom: 5px;" action="<%=basePath%>/SearchCourse" method="post" >
		<div style="overflow: hidden" ><div style="float: left">显示<select name="num"><option value="5" <c:if test="${num==5}">selected</c:if>>5</option><option value="4"<c:if test="${num==4}">selected</c:if>>4
		</option><option value="3" <c:if test="${num==3}">selected</c:if>>3</option><option value="2" <c:if test="${num==2}">selected</c:if>>2</option><option value="1" <c:if test="${num==1}">selected</c:if>>1</option></select></div>
			<div style="float: right"><input type="text" name="searchChar" value="${search_val}"><input type="submit" value="搜索"></div></div>
		</form>
		<hr>
		<table cellspacing="0px" cellpadding="0px" border="1px" width="100%" class="tablelist" id="example" style="text-align: center">
			<thead>
				<tr>
					<th>课程ID</th>
					<th>课程名</th>
					<th>方向</th>
					<th>描述</th>
					<th>时长(小时)</th>
					<th>操作人</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="Course">
					<tr>
						<td>${Course.courseId}</td>
						<td>${Course.courseName}</td>
						<td>${Course.coursePath}</td>
						<td>${Course.courseDes}</td>
						<td>${Course.courseDuration}</td>
						<td>${Course.courseOperator}</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</center>
	<div class="menu">
		<div style="float: left;padding-left: 20px;"><span class="page_des">从<c:choose>
				<c:when test="${size ne 0}"><span>&nbsp;&nbsp;${(page-1)*num+1}&nbsp;&nbsp;</span></c:when>
		        <c:otherwise><span>0</span></c:otherwise>
		   </c:choose>到<span>&nbsp;&nbsp;${end}&nbsp;&nbsp;</span>条记录，共<span>&nbsp;&nbsp;${end-((page-1)*num+1)+1}&nbsp;&nbsp;</span>条(全部记录数<span>&nbsp;&nbsp;${size}&nbsp;&nbsp;</span>条）</span></div>
<div class="page" style="float: right">
	<form action="FirstPage"><input type="submit" value="首页"></form>
	<form action="FrontPage"><input type="hidden" name="page" value="${page}"><input type="submit" value="上一页"></form>
	<form><span>第</span><input type="submit" value="${page}"><span>页</span></form>
	<form action="NextPage"><input type="hidden" name="page" value="${page}"><input type="submit" value="下一页"></form>
	<form action="FinPage"><input type="submit" value="尾页"></form>
</div>
	</div>
</body>
</html>