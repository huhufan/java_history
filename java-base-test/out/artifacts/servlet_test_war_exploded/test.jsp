<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.text.*" %>
<html>
<head>
    <title>我的个人主页</title>
</head>
<body>

<%!
    private int initVar = 0;
    private int serviceVar = 0;
    private int destroyVar = 0;
%>

<%!
    public void jspInit(){
        initVar++;
        System.out.println("初始化了"+initVar+"次");
    }
    public void jspDestroy(){
        destroyVar++;
        System.out.println("销毁了"+destroyVar+"次");
    }
%>

<%
    serviceVar++;
    System.out.println("请求了多少次"+serviceVar+"次");

    String content1 = "初始化的次数："+initVar;
    String content2 = "请求的次数："+serviceVar;
    String content3 = "销毁的次数："+destroyVar;


%>
<h1>测试jsp的生命周期</h1>
<p><%=content1%></p>
<p><%=content2%></p>
<p><%=content3%></p>
</body>
</html>