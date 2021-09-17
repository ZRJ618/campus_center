package com.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SelfDefindExceptionHandle {

    @ExceptionHandler(SelfDefindException.class)
    @ResponseBody
    public ResultBody selfDefindException(SelfDefindException e){
        return new ResultBody(e.getCode(),e.getMessage(),e.getObject());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultBody nullPointerException(NullPointerException e){
        e.printStackTrace();
        return new ResultBody("500","NullPointerException",null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBody exception(Exception e){
        e.printStackTrace();
        return new ResultBody("500",e.getCause().getMessage(),null);
    }

}
