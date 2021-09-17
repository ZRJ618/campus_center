package com.demo.exception;

import lombok.Data;

@Data
public class SelfDefindException extends RuntimeException{
    private String code;
    private String message;
    private Object object;

    //返回的object为null
    public SelfDefindException(com.demo.exception.CommonResultEnum commonResultEnum){
        super(commonResultEnum.getMessage());
        this.code = commonResultEnum.getCode();
        this.message = commonResultEnum.getMessage();
        this.object = null;
    }

    //返回的object不为null
    public SelfDefindException(com.demo.exception.CommonResultEnum commonResultEnum, Object object){
        super(commonResultEnum.getMessage());
        this.code = commonResultEnum.getCode();
        this.message = commonResultEnum.getMessage();
        this.object = object;
    }

    //自定义异常值
    public SelfDefindException(String code,String message,Object object){
        super(message);
        this.code = code;
        this.message = message;
        this.object = object;
    }
}
