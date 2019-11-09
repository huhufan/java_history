package com.example.casedemo.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("address",733);
        map.put("name","樊two");
       // System.out.println((String) webRequest.getAttribute("txt",0));
        map.put("txt",(Map<String,Object>)webRequest.getAttribute("txt",0));
        return map;
    }
}
