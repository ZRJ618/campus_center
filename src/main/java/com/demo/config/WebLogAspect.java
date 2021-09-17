package com.demo.config;

import com.demo.exception.ResultBody;
import com.demo.mapper.LoggerMapper;
import com.demo.pojo.Logger;
import com.demo.util.ParamUtil;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Aspect
@Component
public class WebLogAspect {


    @Autowired
    private LoggerMapper loggerMapper;

    @Pointcut("execution(* com.demo.controller.*.*(..))")
    public void controller(){

    }

    @AfterReturning(value = "controller()",returning = "returnValue")
    public void after(JoinPoint joinPoint, Object returnValue){
        //获取访问的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取传递过来的参数值
        Object[] args = joinPoint.getArgs();
        StringBuilder argsBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            argsBuilder.append(args[i].toString());
            argsBuilder.append("-");
        }


        //获取userId:从获取RequestAttributes中获取HttpServletRequest的信息
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String userId = ParamUtil.getUserId(request);

        Logger logger = new Logger();
        logger.setUserId(userId);
        logger.setMethod(methodName);
        logger.setParam(argsBuilder.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        logger.setExecutionTime(simpleDateFormat.format(new Date()));
        ResultBody resultBody = (ResultBody) returnValue;
        logger.setResult(resultBody.getCode());

        loggerMapper.addLogger(logger);


    }
}
