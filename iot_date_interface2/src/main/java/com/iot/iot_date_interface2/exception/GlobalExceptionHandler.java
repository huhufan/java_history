package com.iot.iot_date_interface2.exception;

import com.iot.iot_date_interface2.entity.WebResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 用来处理bean validation异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public WebResult resolveConstraintViolationException(ConstraintViolationException ex){
        WebResult errorWebResult = new WebResult(WebResult.FAILED);
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if(!CollectionUtils.isEmpty(constraintViolations)){
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder msgBuilder2 = new StringBuilder();

            for(ConstraintViolation constraintViolation :constraintViolations){
                msgBuilder.append(constraintViolation.getMessage()).append(",");
                msgBuilder2.append(constraintViolation.getInvalidValue()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            String errorMessage2 = msgBuilder2.toString();

            if(errorMessage.length()>1){
                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
            }
            if(errorMessage2.length()>1){
                errorMessage2 = errorMessage2.substring(0,errorMessage2.length()-1);
            }
            errorWebResult.setInfo(errorMessage);
            errorWebResult.setData(errorMessage2);
            return errorWebResult;
        }
        errorWebResult.setInfo(ex.getMessage());
        return errorWebResult;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public WebResult resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        WebResult errorWebResult = new WebResult(WebResult.FAILED);
        List<ObjectError>  objectErrors = ex.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder msgBuilder2 = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
                msgBuilder2.append("object: "+objectError.getObjectName()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            String errorMessage2 = msgBuilder.toString();
            if (errorMessage2.length() > 1) {
                errorMessage2 = errorMessage2.substring(0, errorMessage2.length() - 1);
            }
            errorWebResult.setInfo(errorMessage);
            errorWebResult.setData(msgBuilder2);

            return errorWebResult;
        }
        errorWebResult.setInfo(ex.getMessage());
        return errorWebResult;
    }
}