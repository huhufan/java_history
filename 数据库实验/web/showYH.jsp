<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/15
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户管理</title>
    <style>
        body{
            padding:0;
            margin: 0;
        }
        #hidd2{
            position: absolute;
            top: 150px;
            left:100px;
            height: 150px;
            background-color: lightgray;
            width:100px ;
            display: none;
        }
        #hidd2 div{
            margin-top: 20px;
        }
         a{
            width:100px ;
            height: 30px;
            color: black;
             text-decoration: none;
         }
         .fun{
             position: absolute;
             top: 150px;
             left: 0px;
             width: 100px;
             height: 40px;
             padding-top: 20px;
             background-color: lightgray;
         }
         .fun div{
             padding-top: 20px;
             margin-top: 20px;
         }
        .select{
            display: none;
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
     <div class="fun"><a href="#" onclick="a()">选择操作</a></div><div id="hidd2"><div><a href="#" onclick="b()">查看</a></div><div><a href="#" onclick="c()">修改</a></div>
     <div><a href="#" onclick="d()">删除</a></div></div>
     <form id="ss">
         <table style="text-align: center">
                 <tr><td></td><td>用户id</td><td>用户名</td><td>性别</td><td>邮箱</td></tr>
                 <c:forEach var="user" items="${requestScope.users}">
                 <tr><td><input type="radio" name="id" value="${user.id}" class="select"></td><td>${user.id}</td><td>${user.username}</td><td>${user.sex}</td><td>${user.emial}</td></tr>
             </c:forEach>
          </table>
     </form>
 </center>
<script type="text/javascript">
    function time() {
        setTimeout(function (){document.getElementById("hid").innerText="";}
            ,3000);
    }
    function a() {
        var c = [];
        c = document.getElementsByClassName("select");
        for (var i = 0; i < c.length; i++) {
            var e = window.getComputedStyle(c[i],null).getPropertyValue("display");
            if (e=="none") {
                c[i].style.display="block";
            }
            if (e=="block") {
                c[i].style.display="none";
            }
        }
        var h =document.getElementById("hidd2");
        var d = window.getComputedStyle(h,null).getPropertyValue("display");
        if (d=="none") {
            h.style.display="block";
        }
        if (d=="block") {
            h.style.display="none";
        }
    }
     function b() {
         var  b = document.getElementById("ss");
         b.action="lookDetail";
         b.submit();
    }
    function c() {
        var  b = document.getElementById("ss");
        b.action="manUpdate";
        b.submit();
    }
    function d() {
        var  b = document.getElementById("ss");
        b.action="manDelete";
        b.submit();
    }

</script>
</body>
</html>
