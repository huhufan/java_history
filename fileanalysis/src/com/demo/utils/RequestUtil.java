package com.demo.utils;

import dto.ParamDto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RequestUtil {
    public static ParamDto parseParam(HttpServletRequest request) {
        ParamDto result=new ParamDto();
        ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("utf-8");
        try {
            List<FileItem> fileItemList= upload.parseRequest(request);
            for (FileItem fileItem:fileItemList){
                if (fileItem.isFormField()){
                    result.getParamMap().put(fileItem.getFieldName(),fileItem.getString("utf-"));
                   // System.out.println(fileItem.getFieldName()+","+fileItem.getString("UTF-8"));
                }else {
                    result.getFileMap().put(fileItem.getFieldName(),fileItem);
                   // System.out.println(fileItem.getFieldName());
                   // fileItem.write(new File("G:/upload/"+fileItem.getName()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
