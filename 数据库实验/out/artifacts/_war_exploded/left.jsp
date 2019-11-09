<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title></title>
<style type="text/css">
	.c1{
		width:300px;
		cursor:pointer;
	}
	.c2{
		width:300px;
		padding-left: 30px;
	}
	a{
		text-decoration: none;
		color: #000000;
	}

</style>
</head>
<body>
	<c:choose>
		<c:when test="${user.usersign eq 2}">
			<div class="c1">
				<h3><a href="/zzlist.do" target="main">观看直播</a></h3>
				<h3 onclick="show1()"><a>个人信息管理</a></h3>
				<div class="c2" id="menu1" style="display:none;">
					<p><a href="/userDetail.jsp" target="main">查看个人信息</a></p>
					<p><a href="/updateUser.jsp" target="main">修改个人信息</a></p>
				</div>
				<h3><a href="/JspServlet" target="main">成为主播</a></h3>
				<h3><a href="/back.jsp" target="main">反馈</a></h3>
			</div>
		</c:when>
		<c:otherwise>
			<%--修改删除用户--%>
			<h3><a href="/userMan" target="main">用户管理</a></h3>
			<%--修改删除主播  查看礼物收入--%>
			<h3><a href="/zzMan" target="main">主播管理</a></h3>
			<h3><a href="/banMan" target="main">查看反馈</a></h3>
		</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		function show1(){
			var menu = document.getElementById("menu1");
			var displayStyle = menu.style.display;
			if(displayStyle=="none"){
				menu.style.display="block";
			}else{
				menu.style.display="none";
			}
		}
	</script>
</body>
</html>