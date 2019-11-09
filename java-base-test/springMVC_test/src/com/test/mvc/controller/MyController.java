package com.test.mvc.controller;

import com.test.mvc.exception.MyFirstException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @auther hu  .
 * @create 2019/8/21
 */

@Controller
public class MyController {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "success";
    }

    @RequestMapping("/testModel")
    public String testModel(ModelMap modelMap) {
        return "success";
    }


    @RequestMapping()
    public String toFile() {
        return "testFileUpload";
    }

    @RequestMapping("/testResponseStatusExceptionHandle")
    public String testResponseStatusExceptionHandle() {
        throw new MyFirstException();
    }


    @RequestMapping("/testFileUpload")
    public String testFile(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("originalFilename: " + file.getOriginalFilename());
        file.getInputStream();
        file.getBytes();
        file.getName();
        file.getContentType();
        file.isEmpty();
        file.transferTo(new File(""));
        return "success";
    }
}
