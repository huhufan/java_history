<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>#code{height:30px;}</style>
</head>
<body>

<form action="submit.action">

    <p> <input type="text" name="kaptcha" id="code" value="" maxlength="5" placeholder="请输入验证码"/>
    <img src="http://localhost:8080/kaptcha.jpg" id="changecode"/>
    </p>
    <p>
    <input type="button" id="login" value="登录">
    </p>
    <div id="result"></div>
</form>

<script src="js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script>

    $(function(){
        $("#changecode").on("click",function(){
            $(this).attr("src","http://localhost:8080/kaptcha.jpg?d="+new Date().getTime());
        });
         //给登录按钮绑定点击事件
        $("#login").on("click",function(){
            //获取用户输入的验证码
            var code = $("#code").val();
            //alert(code);
            var params = {"code":code};
            $.post("http://localhost:8080/LoginServlet",params,function(data){

                if(data=="success"){
                    $("#result").html("验证码输入正确");
                }else{
                    $("#result").html("验证码输入有误，请重新输入...");
                    $("#code").val("").focus();
                }
            });
        });
    })

</script>

</body>
</html>
