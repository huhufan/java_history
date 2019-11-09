package com.test.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @auther hu  .
 * @create 2019/8/23
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "我就是一个异常")
public class MyFirstException extends RuntimeException {
    static final long serialVersionUID = -45766939L;
}
