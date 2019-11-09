package com.test.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @auther hu  .
 * @create 2019/8/23
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView HandlerArithmeticException(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }
}
