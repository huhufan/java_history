<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/8/3
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
    <meta http-equiv="prama" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<img src="code.jsp" alt="" id="code">
<a href="javascript:void(0)" onclick="changecode()">看不清，点我</a>
<script>
    function changecode(){
        document.getElementById("code").src="code.jsp?d="+new Date().getTime();
    }

</script>

</body>
</html>
