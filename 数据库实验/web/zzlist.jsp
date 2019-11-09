<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/16
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        a{
            text-decoration: none;
            margin-left: 20px;
            color:cadetblue;

            border: 0.5px solid black;
        }
        td{
            padding-right: 30px;
        }
    </style>
</head>
<body onload="time()">
<center>
    <c:if test="${tip ne null}">
        <h3 id="hid" style="color: seagreen; height: 50px">${tip}</h3>
    </c:if>
    <c:if test="${tip eq null}">
        <h3 id="hid" style="color: seagreen; height: 50px"></h3>
    </c:if>
<table style="text-align: center">
    <tr><td>主播id</td><td>主播名</td><td>密码</td><td>直播标题</td><td>性别</td><td>Email</td><td>操作</td></tr>
    <c:forEach var="zz" items="${zzs}">
        <tr><td>${zz.id}</td><td>${zz.username}</td><td>${zz.password}</td><td>${zz.title}</td><td>${zz.sex}</td><td>${zz.emial}</td>
            <td><a href="zzdelete?id=${zz.id}">删除</a><a href="zzupdate?id=${zz.id}">修改</a><a href="getLW?id=${zz.id}">礼物收入</a>
                <c:if test="${zz.zz_sign eq '0'}">
                    <a href="addTJ?id=${zz.id}">加入推荐</a>
            </c:if>
                <c:if test="${zz.zz_sign eq '1'}">
                    <a href="delTJ?id=${zz.id}">取消推荐</a>
                </c:if>
            </td></tr>
    </c:forEach>
</center>
</table>
<script type="text/javascript">
    function time() {
        setTimeout(function (){document.getElementById("hid").innerText="";}
            ,3000);
    }
</script>
</body>
</html>
