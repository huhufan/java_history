package com.demo.utils;

import org.apache.commons.fileupload.FileItem;

import javax.xml.crypto.Data;
import java.io.File;

public class FileUtil {
    public  static final String path="d:/upload/";
    public static String save(FileItem fileItem,String path) throws Exception {
     String fileName= System.currentTimeMillis()+fileItem.getName();

            fileItem.write(new File(path+fileName));

        return  fileName;
    }
}
