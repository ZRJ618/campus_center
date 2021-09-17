package com.demo.exception;

import lombok.Data;

@Data
public class ResultBody {
    private String code;
    private String msg;
    private Object result;

    public ResultBody() {
    }

    public ResultBody(BaseErrorInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.msg = errorInfo.getResultMsg();
    }

    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMsg(CommonEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInterface errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMsg(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMsg(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error( String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("500");
        rb.setMsg(message);
        rb.setResult(null);
        return rb;
    }

    public static ResultBody ResHandle(boolean flag, String message) {
        if(flag) {
            return ResultBody.success(null);
        }else {
            return ResultBody.error(message);
        }
    }

    public static ResultBody ResHandle(Object data, String message) {
        if(data != null) {
            return ResultBody.success(data);
        }else {
            return ResultBody.error(message);
        }
    }

    //完全自定义返回值
    public ResultBody(String code, String message, Object object) {
        this.code = code;
        this.msg = message;
        this.result = object;
    }

    //通过CommonResultEnum初始化ResultBody
    public ResultBody(CommonResultEnum commonResultEnum,Object object){
        this.code = commonResultEnum.getCode();
        this.msg = commonResultEnum.getMessage();
        this.result = object;
    }

    //返回成功，object为null
    public static ResultBody success(){
        Object object = null;
        return new ResultBody(CommonResultEnum.SUCCESS,object);
    }

    //返回成功，object不为null
/*    public static ResultBody success(Object object){
        return new ResultBody(CommonResultEnum.SUCCESS,object);
    }*/

    //返回失败，object为null
    public static ResultBody exception(CommonResultEnum commonResultEnum){
        Object object = null;
        return new ResultBody(commonResultEnum,object);
    }

    //返回失败，object不为null
    public static ResultBody exception(CommonResultEnum commonResultEnum, Object object){
        return new ResultBody(commonResultEnum,object);
    }

    //返回失败，code为500
    public static ResultBody exception500(String message){
        String code = "500";
        return new ResultBody(code,message,null);
    }

    //返回失败，code为500
    public static ResultBody exception500(String message, Object object){
        String code = "500";
        return new ResultBody(code,message,object);
    }
}
