package com.imooc.utils;

import java.util.UUID;

public class UploadUtils {
    public static String getUUID(String fileName){
        int ind=fileName.lastIndexOf(".");
        String extent=fileName.substring(ind);
        String url= UUID.randomUUID().toString().replace("-","")+extent;
        return url;
    }
    public static String getURL(Food food){
        if (food.getFoodImage()==null){
            return null;
        }
      int ind=  food.getFoodImage().lastIndexOf("\\");
      return food.getFoodImage().substring(ind+1);

    }
}
