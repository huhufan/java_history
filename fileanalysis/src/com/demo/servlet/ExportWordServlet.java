package com.demo.servlet;

import com.demo.utils.WordService;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.XMLFormatter;

@WebServlet(name = "ExportWordServlet")
public class ExportWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        WordService wordService = new WordService();
        Map<String, String> param = new HashMap<>();
        param.put("${name}", request.getParameter("name"));
        param.put("${age}", request.getParameter("age"));
        param.put("${time}", request.getParameter("time"));
        ServletOutputStream outputStream = response.getOutputStream();
        if (request.getParameter("isDocx") != null & request.getParameter("isDicx").equals("")) {
            XWPFDocument docx = wordService.export07(param);
            response.setHeader("Content-Disposition", "attachment,filename=export.doc");
            docx.write(outputStream);
            docx.close();
        } else {
            HWPFDocument doc = wordService.export03(param);
            response.setHeader("Content-Disposition", "attachment,filename=export.doc");
            doc.write(outputStream);
            doc.close();
        }
        outputStream.flush();
        outputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
