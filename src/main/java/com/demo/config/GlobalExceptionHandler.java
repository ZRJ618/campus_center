package com.demo.config;

import com.demo.exception.CommonEnum;
import com.demo.exception.GlobalException;
import com.demo.exception.ResultBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ResultBody AllExceptionHandler(GlobalException e){
        return ResultBody.error(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(NullPointerException e){
        e.printStackTrace();
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e){
        e.printStackTrace();
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
