package com.imooc.sso.servlet;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {

    private ExecutorService service= Executors.newFixedThreadPool(10);
    private void setCookie(String server,String ticket) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                HttpPost httpPost=new HttpPost(server+"/setCookie?ticket="+ticket);
                CloseableHttpClient httpClient=null;
                CloseableHttpResponse response=null;
                try {
                    httpClient= HttpClients.createDefault();
                    response=httpClient.execute(httpPost);
                    HttpEntity entity=response.getEntity();
                    String responseContent= EntityUtils.toString(entity,"utf-8");
                    System.out.println("====================="+responseContent);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(response!=null){
                        try {
                            response.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }if (httpClient!=null){
                        try {
                            httpClient.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/mian",request.getServletPath())){
            String domains= request.getParameter("domains");
            String ticket=request.getParameter("ticket");
            for (String server:domains.split(",")){
                if (Objects.equals(null,server)&& Objects.equals("",server.trim())){
                         setCookie(server,ticket);
                }
            }request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);

        }else if (Objects.equals("/setCookie",request.getServletPath())){
            String ticket=request.getParameter("ticket");
            response.addCookie(new Cookie("Ticket_Granting_Ticket",ticket));
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/text;charset=utf-8");
            PrintWriter out= null;
            try{  out=response.getWriter();
            out.write("ok");}
            catch (IOException e){
                e.printStackTrace();
            }finally {
                if(out!=null)
                    out.close();
            }



        }
    }
}
