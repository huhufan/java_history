package com.test.mvc.controller;

import com.test.mvc.exception.MyFirstException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @auther hu  .
 * @create 2019/8/23
 */
@Controller
public class TestExceptionHandler {

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
        System.out.println(10/i);
        return "success";
    }

    /**
     * 1.@在ExceptionHandler方法的参数中可以加入Exception类型的参数，该参数即对应发生的异常对象
     * 2. 入参中不能传入Map，若希望将异常信息显示在页面上，需要使用ModelAndView 作为返回值
     * 3. 方法标记的异常有优先级的问题
     * 4. 如果在当前Handler 中找不到@ExceptionHandler方法来处理当去方法出现的异常，则将去@ControllerAdvice 标记的类中查找@ExceptionHandler标记的方法来处理异常
     */
    @ExceptionHandler({ArithmeticException.class})
        public ModelAndView HanderArithmeticException(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }
    @RequestMapping("/testResponseStatusExceptionResolver")
    public void testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if (i != 0) {
            throw new MyFirstException();
        }
    }
}
