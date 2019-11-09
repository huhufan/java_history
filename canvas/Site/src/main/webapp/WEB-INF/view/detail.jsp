<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="../../style/common.css" />
    <link rel="stylesheet" type="text/css" href="../../style/detail.css" />
<!--<link rel="stylesheet" type="text/css" href="style/reset.css" />
    <link rel="stylesheet" type="text/css" href="style/style.css" />-->
</head>
<body class="bgf8">
    <div class="header">
        <div class="logo f1">
            <img src="../../image/logo.png">
        </div>
        <div class="auth fr">
            <ul>
                <li><a href="#">登录</a></li>
                <li><a href="#">注册</a></li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="section" style="margin-top:20px;">
            <div class="width1200">
                <div class="fl"><img src="../../image/MG_details_03.jpg"/></div>
                <div class="fl sec_intru_bg">
                    <dl>
                        <dt>${canvas.name}</dt>
                        <dd>
                            <p>发布人：<span>${canvas.creator}</span></p>
                            <p>发布时间：<span>${canvas.createTime}</span></p>
                            <p>修改时间：<span>${canvas.updateTime}</span></p>
                        </dd>
                    </dl>
                    <ul>
                        <li>售价：<br/><span class="price">${canvas.price}</span>元</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="secion_words">
            <div class="width1200">
                <div class="secion_wordsCon">
                    <p>${canvas.description}</p>
                            </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
            </div>
        </div> 
    </body>
    </html>
