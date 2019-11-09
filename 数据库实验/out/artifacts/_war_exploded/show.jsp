<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/11/10
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
    <title></title>
    <style>
        .plate{
            background-color: lightgray;
            height: 50px;
            width: 800px;
        }
        .plate-2{
            margin-top: -10px;
            background-color: lightgray;
            height: 30px;
            width: 800px;
        }
        a{
            text-decoration: none;
            color: black;
        }
        a:hover{
            background-color: aliceblue;
        }
        li{
            list-style-type: none;
        }
        .plate li{
            line-height: 50px;
            float: left;
            margin-left: 70px;
        }
        .plate-2 li{
            line-height: 30px;
            float: left;
            margin-left: 70px;
        }
        .show{
            margin-left:10.5%;
            font-size: 12px;
            width: 950px;
        }
        .show li{
            float: left;
            margin-left: 25px;
            margin-top: 25px;
        }
        .show .show-content{
            position: relative;
            background-color: aliceblue;
            height: 200px;
            width: 200px;
        }
        .show .title{
            width: 100%;
            text-align: center;
            padding-top: 30px;
        }
        .show .name{
            width: 100%;
            text-align: center;
            position: absolute;
            bottom: 60px;
        }
        .show .operate{
            height: 40px;
            position: absolute;
            bottom: 20px;
            margin-left: 20px;
        }
        .show .operate a{
            line-height: 40px;
            margin-left: 20px;
            height: 40px;
            width: 50px;
            background-color: lightgray;
        }
        #hover1{
            width: 200px;
            height: 100px;
            position: absolute;
            left: 108px;
            top: 150px;
            background-color:cornsilk;
            z-index: 9999;
            display: none;

        }
        #hover2{
            width: 200px;
            height: 200px;
            position: absolute;
            left: 153px;
            top: 150px;
            background-color: cornsilk;
            z-index: 9999;
            display: none;
        }
        input{
            height: 20px;
            margin-top: 30px;
        }

    </style>
</head>
<body onload="time()">
<center>
<ul class="plate">
    <c:choose>
        <c:when test="${bkid eq 'TJ'}">
            <li><a style="background-color:aliceblue" href="zzlist.do?bkid=TJ">推荐</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="zzlist.do?bkid=TJ">推荐</a></li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${bkid eq 'DY'}">
            <li><a style="background-color:aliceblue" href="zzlist.do?bkid=DY">订阅</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="zzlist.do?bkid=DY">订阅</a></li>
        </c:otherwise>
    </c:choose>
    <%--<li><a href="zzlist.do?bkid=TJ"></a></li>--%>
    <%--<li><a href="zzlist.do?bkid=DY">订阅</a></li>--%>
    <c:forEach var="BK" items="${bklist}">
        <c:choose>
            <c:when test="${bkid eq BK.id}">
                <li><a style="background-color:aliceblue" href="zzlist.do?bkid=${BK.id}">${BK.name}</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="zzlist.do?bkid=${BK.id}">${BK.name}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>
    <c:if test="${not empty zbklist}">
    <ul class="plate-2">
    <c:forEach var="BK" items="${zbklist}">
        <c:choose>
            <c:when test="${zbkid eq BK.id}">
                <li><a style="background-color:aliceblue" href="zzlist.do?zbkid=${BK.id}">${BK.name}</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="zzlist.do?zbkid=${BK.id}">${BK.name}</a></li>
            </c:otherwise>
        </c:choose>
   </c:forEach>
    </ul>
    </c:if>
    <%--<c:if test="${warn != null}">--%>
        <h6 id="warn" style="color: darkcyan;height: 20px">${requestScope.warn}</h6>
    <%--</c:if>--%>
</center>
<div class="show">
    <ul id="uls">
        <c:forEach var="zz" items="${zzlist}">
            <li li_id="${zz.id}"><div class="show-content"><a href="${zz.room_url}"><div class="title">${zz.title}</div><div class="name">${zz.username}</div></a><div class="operate">
            <a class="dy_a" href="/sub?id=${zz.id}">订阅</a>   <a href="#" id="${zz.id}" onclick="show2(this.id)">送礼</a><a href="getLW?id=${zz.id}">榜单</a></div>
            <div id="hover1" class="${zz.id}" onmouseleave="show3(this.className)"><center><form action="/songli"><input type="hidden" value="${zz.id}" name="zzid"><input type="number" name="num" placeholder="请输入金币数量"><input style="background-color: lightgray" type="submit" value=" 送 "></form></center></div>
            </div></li>
        </c:forEach>
    </ul>
</div>
<script type="text/javascript">
    function time() {
        setTimeout(function (){document.getElementById("warn").innerText="";}
    ,3000);
    }
    $(document).ready(function () {
        $("#uls").find("li").each(function (i) {
             var a = $(this);
             var zb_id = parseInt(a.attr("li_id"));
            $.ajax({
                url:"<%=basePath%>/dy_status",
                type:"post",
                data:{
                    zb_id:zb_id,
                },
                dataType:"json",
                success:function(result){
                    var flag = result.flag;
                    if(flag==true){
                        var b = a.find("a.dy_a");
                        b.text("已订阅");
                        b.attr("href","/cancel_sub?id="+zb_id);
                    }
                }
            });
        })
    });
    function show2(id) {
        var hov = document.getElementsByClassName(id)[0];
        hov.style.display = "block";
    }
    function show3(className) {
        var d = document.getElementsByClassName(className)[0];
        d.style.display="none";
    }

</script>
</body>
</html>
