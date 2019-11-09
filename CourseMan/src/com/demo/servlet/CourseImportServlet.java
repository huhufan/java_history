package com.demo.servlet;

import com.demo.datapro.ExcelService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseImportServlet extends HttpServlet {
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      ServletFileUpload upload= new ServletFileUpload(new DiskFileItemFactory());
      upload.setHeaderEncoding("UTF-8");
      try {
         List<FileItem> fileItems=upload.parseRequest(req);
         for (FileItem fileItem:fileItems){
            if (!fileItem.isFormField()) {
               ExcelService service=new ExcelService();
                  service.imp(fileItem,(String) req.getSession().getAttribute("username"));
            }
         }
      } catch (Exception e) {
            req.setAttribute("hint","由于文件格式或文件内容格式的原因，无法解析");
            req.getRequestDispatcher("WEB-INF/views/courseImport.jsp").forward(req,resp);
            return;
      }
      req.getRequestDispatcher("/GetCourseServlet").forward(req,resp);
   }



}
