package com.highcom.turingchat.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class ChatServlet extends HttpServlet {

	
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String APIKEY="5d655991fcc94148a614ac670d428f54";
        String INFO=request.getParameter("info");
		try {
			INFO = URLEncoder.encode(INFO,"utf-8");
			String requrl="http://www.tuling123.com/openapi/api?key="+APIKEY+"&info="+INFO;
			
			
			HttpGet req=new HttpGet(requrl);
			HttpResponse res=HttpClients.createDefault().execute(req); //通过客户端工具去执行请求
            
			if(res.getStatusLine().getStatusCode()==200){  //得到http响应结果的状态代码
	        	String result=EntityUtils.toString(res.getEntity());  //获取响应消息实体变成字符串
	        	//System.out.println("返回结果："+result);
	        	//把返回的数据返回给页面
	        	response.setContentType("text/html;charset=utf-8");//解决响应乱码
	    		PrintWriter out=response.getWriter();
	    		out.print(result);
           }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
