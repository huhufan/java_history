package com.demo.sql.common;

import com.demo.sql.dao.ZZDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetId {
    ZZDAO zzdao = new ZZDAO();

    public String getNextId(String MAXId,String tableName) {
        String id ;
        if (MAXId == null) {
            id = tableName + "001";
        } else {
            String p1 =  "[^0-9]";
            Pattern c = Pattern.compile(p1);
            Matcher matcher = c.matcher(MAXId);
            String a = matcher.replaceAll("").trim();
            int b = Integer.parseInt(a)+1;
            String n = String.format("%03d",b);
            id = tableName + n;
        }
        return id;
    }

}

