package com.imooc.sm.golbal;

import com.imooc.sm.entity.Log;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogAdvice {
    @Autowired
    LogService logService;
    @After("execution(* com.imooc.sm.controller.*.*(..)) && !execution(* com.imooc.sm.controller.Self*.*(..)) &&!execution(* com.imooc.sm.controller.*.to*(..))" )
    public void operationLog(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff = (Staff) request.getSession().getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        logService.addOperationLog(log);
    }

    @AfterThrowing(throwing="e" ,pointcut = "execution(* com.imooc.sm.controller.*.*(..)) && !execution(* com.imooc.sm.controller.Self*.*(..))" )
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff = (Staff) request.getSession().getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }
    @After("execution(* com.imooc.sm.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff = (Staff) request.getSession().getAttribute("USER");
        if (staff==null){
            log.setResult("失败");
            log.setOperator(request.getParameter("account"));
            logService.addLoginLog(log);
        }
        else{
            log.setResult("成功");
            log.setOperator(staff.getAccount());
            logService.addLoginLog(log);
        }

    }
    @Before("execution(* com.imooc.sm.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        Staff staff = (Staff) request.getSession().getAttribute("USER");
        log.setResult("成功");
        log.setOperator(staff.getAccount());
        logService.addOperationLog(log);
    }
}
