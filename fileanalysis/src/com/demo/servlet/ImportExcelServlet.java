package com.demo.servlet;

import com.demo.utils.ExcelService;
import com.demo.utils.RequestUtil;
import dto.ImportExcelParamDto;
import dto.ImportExcelResultDto;
import dto.ParamDto;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImportExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
          ParamDto dto=RequestUtil.parseParam(request);
            ImportExcelParamDto paramDto=new ImportExcelParamDto();
            paramDto.setTitle(dto.getParamMap().get("title"));
            paramDto.setExcel(dto.getFileMap().get("excel"));
            ExcelService service=new ExcelService();
            ImportExcelResultDto resultDto=service.imp(paramDto);
            request.setAttribute("resule",resultDto);
        } else {

        }
        request.getRequestDispatcher("/WEB-INF/jsp/importExcelResult.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
