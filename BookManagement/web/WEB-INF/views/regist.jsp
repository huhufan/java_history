
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
</head>
<body>
	<center>
		<h1>用户注册</h1>
		<form action="<%=basePath%>/RegistServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合" pattern="[0-9_a-zA-Z]{3,12}" required></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password"  placeholder="密码长度为6-12位的纯数字"  id="password" pattern="[\d]{6,12}" required></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="checkPWD" id="check" placeholder="密码长度为6-12位的纯数字" pattern="[\d]{6,12}"
                               required ></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" placeholder="请输入正确的手机号码格式" pattern="[\d]{11}" ></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="email" name="email" placeholder="请输入正确邮箱格式" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="注册">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
<script>
         var check=document.getElementById("check");
         check.onmouseout=function () {
             var password=document.getElementById("password");
             var passVal=password.value;
             var check=document.getElementById("check");
             var checkVar=check.value;
             if (passVal!==checkVar) {
                 alert("两次密码不一致");
             }
         }
</script>

	
</body>
</html>