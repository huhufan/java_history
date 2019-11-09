<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>海康实训-智能聊天系统-chellis</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script src="js/jquery-1.8.0.js"></script>
    <link rel="stylesheet" href="css/indexStyle.css"/>
    </head>
  
  <body>
  <div class="box">
     <div class="header">
        <img src="images/logo.png">
        <span>24小时智能服务</span>
     </div>
     <div class="chatArea">
         <textarea id="info" style="max-width:100%;min-width:100%;max-height:100px;min-height:100px;"></textarea>
         <input type="button" value="取消" onclick="doreset()">
         <input type="button" value="发送" onclick="dosubmit()">
     </div>  
        
     <div id="res" style="1px solid red">
        <div class="mbox"></div>
     </div>
    
     
  </div>
   
    <script >
    
    //回车键提交
    $(function(){
       $("#info").keydown(function(e){
         	   if(e.keyCode == "13"){  //enter键的ASCII是13 
         	      dosubmit();
         	      //scrollTop滚动了的距离，scrollHeight需要滚动的距离
         	      $("#res").scrollTop($("#res")[0].scrollHeight+$(".robotInfo").last().height());
         	   }
         	});
    });
     //输入的内容提交
     function dosubmit(){
         if($("#info").val().trim()!=""){          
         	$("#res .mbox").append("<div class='userInfo'><img src='images/user.jpg'>"+$("#info").val()+"</div>");
         	$.ajax({
         			type:"post",
         			dataType:"json",
         			async:false,
         	        data:{	
         	        	info:$("#info").val()
         	        	},
         	        url:"ChatServlet",
         	        //url:"talk.do",
         	        success:function(recvdata){
         	       		 //$("#res").append("<img>");
         	        	 if(recvdata!=null){
		         	        $("#res .mbox").append("<div class='robotInfo'><img src='images/robot.jpeg'>"+recvdata.text+"</div>");
		         	     }else{
		         	        $("#res .mbox").append("<div class='robotInfo'><img src='images/robot.jpeg'>没听明白你的意思！</div>");
		         	     }
         	        }
         	});
         	$("#info").val("");
         }
      }
      
      //输入的内容重置
      function doreset(){
        $("#info").val("");
      }
    </script>
  </body>
</html>
