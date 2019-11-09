<%@page language="java" contentType="text/html; charSet=UTF-8"  pageEncoding="UTF-8" %>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程添加</title>
</head>
<body>
	<center>
		<h1>课程添加</h1>
		<h6 style="color: darkcyan">${hint}</h6>
		<hr>
		<form action="<%=basePath%>/AddCourseServlet" method="post" onsubmit="return validateCode()">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>课程ID</td>
					<td><input type="text" name="courseId" placeholder="数字格式且不能为空" pattern="[0-9]{1,}" ></td>
				</tr>
				<tr>
					<td>课程名</td>
					<td><input type="text" name="courseName" placeholder="不能为空"></td>
				</tr>
				<tr>
					<td>方向</td>
					<td>
						<select name="coursePath">
							<option value="Java">Java</option>
							<option value="前端">前端</option>
							<option value="Linux">Linux</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>描述</td>
					<td>
						<textarea name="courseDes"></textarea>
					</td>
				</tr>
				<tr>
					<td>时长</td>
					<td>
						<input name="courseDuration" type="text" pattern="[0-9]{0,}" placeholder="请输入数字格式">
					</td>
				</tr>
				<tr>
					<td>操作人</td>
					<td>
						<input name="courseOperator" type="text" value="${username}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>