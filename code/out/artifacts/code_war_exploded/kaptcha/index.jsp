<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/8/5
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码框架</title>
</head>
<body>
<form action="submit.action">
    <input type="text" name="kaptcha" value="" /><img src="http://localhost:8080/kaptcha.jpg" />
</form>
</body>
</html>
