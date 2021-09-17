package com.demo.exception;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException{
    private String errorCode;
    private String errorMsg;

    public GlobalException(){
        super();
    }

    public GlobalException(BaseErrorInterface baseErrorInterface){
        super(baseErrorInterface.getResultCode());
        this.errorCode = baseErrorInterface.getResultCode();
        this.errorMsg = baseErrorInterface.getResultMsg();
    }

    public GlobalException(BaseErrorInterface baseErrorInterface, Throwable cause){
        super(baseErrorInterface.getResultCode(), cause);
        this.errorCode = baseErrorInterface.getResultCode();
        this.errorMsg = baseErrorInterface.getResultMsg();
    }

    public GlobalException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public GlobalException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
}
