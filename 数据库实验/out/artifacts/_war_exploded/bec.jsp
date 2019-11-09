<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/12
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
    <title>修改个人信息</title>
    <style>
        tr{
            width: 100px;
            height: 40px;
            font-size: 20px;
        }
        .con{
            color: darkcyan;
        }
    </style>
</head>
<body>
<center>
    <form action="/bec">
    <table style="text-align: center">
        <tr> <td>用户名:</td><td><span>${user.username}</span</td></tr>
        <tr><td>性别：</td><td><span>${user.sex}</span></td></tr>
        <tr><td>邮箱：</td><td><span>${user.emial}</span></td></tr>
        <tr><td>子板块：</td><td><select name="zbk"><c:forEach var="zbk" items="${zbk}"><option value="${zbk.id}">${zbk.name}</option></c:forEach></select></td></tr>
        <tr><td>直播标题：</td><td><input type="text" name="title"></td></tr>
        <tr><td>Room-URL：</td><td><input type="text" name="url"></td></tr>
    </table>
        <h3> <input type="submit" value="提交更新"></h3>
    </form>
</center>
<script type="text/javascript">
    $("#get").onclick(function(){
        //单击登录按钮的时候触发ajax事件
        $.ajax({
            url:"<%=basePath%>/zbk",
            type:"post",
            data:{
                bk:$("input[bk]").val(),
            },
            dataType:"json",
            success:function(result){
                var list = JSON.parse(data);
                if(flag==false){
                    alert("false")
                }else{
                   alert(list)
                }
            }

        });
    });
</script>
</body>
</html>
