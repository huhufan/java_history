<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="prama" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<title>登录页面</title>
<style type="text/css">
	.code 
	{
	 font-family:Arial;
	 font-style:italic;
	 color:blue;
	 font-size:20px;
	 border:0;
	 padding:2px 3px;
	 letter-spacing:3px;
	 font-weight:bolder;
	 float:left;
	 cursor:pointer;
	 width: 80px;
	 height:20px;
	 line-height:20px;
	 text-align:center;
	 vertical-align:middle;
	}
	a 
	{
	 text-decoration:none;
	 font-size:12px;
	 color:#288bc4;
	}
	a:hover 
	{
	 text-decoration:underline;
	}
</style>
<% String hint="";if (request.getAttribute("hint")!=null){ hint=(String)request.getAttribute("hint");}%>
</head>
<body>
	<center>
		<h1>用户登录</h1>
		<h6 id="h"><%=hint%></h6>
		<form action="<%=basePath%>/LoginServlet" class="form" method="post" onsubmit="return validateCode()">
			<table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td colspan="2"><input type="text" name="username" id="username" placeholder="用户名为3-12位字母数字或下划线组合"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td  colspan="2"><input type="password" name="password" id="password" placeholder="长度为5-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>验证码</td>
					<td style="border-right-style:none;">
						<input type="text" id="code" name="checkCode" placeholder="请输入验证码" maxlength="4">
					</td>
					<td style="border-left-style:none;"><div class="code"  onclick="changeImg()"><img id="change" src="code.jsp"></div></td>
					<span id="result"></span>
				</tr>
				<tr>
					<td colspan="3" style="text-align:center">
						<input type="button" value="登录" id="login">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
		<script src="js\jquery-1.12.4.min.js" type="text/javascript"></script>
		<script>
			function changeImg() {
				 document.getElementById("change").src="code.jsp?d="+new Date().getTime();
            }
            $("#login").on("click",function(){
                //获取用户输入的验证码
                var code = $("#code").val();
                var username=$("#username").val();
                var password=$("#password").val();
                var params = {"code":code,"username":username,"password":password};
                $.post("<%=basePath%>/LoginServlet",params,function(data){
                    if(data=="fail"){
                       alert("验证码输入错误");
                        window.location.href="index";
                    }if(data=="0"){
                        alert("账号或密码错误");
						window.location.href="index";
                    }if(data=="1"){
                        window.location.href="server";
                    }
                });
            })

		</script>
	</center>
</body>
</html>