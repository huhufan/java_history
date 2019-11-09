package com.demo.servlet;

import com.demo.datapro.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExportCourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExcelService service=new ExcelService();
        Workbook workbook=service.export();
        resp.setHeader("Content-Disposition","attachment;filename=export.xlsx");
        ServletOutputStream outputStream=resp.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        workbook.close();
    }
}
