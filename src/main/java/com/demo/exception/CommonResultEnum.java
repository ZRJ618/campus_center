package com.demo.exception;

public enum CommonResultEnum {
    SUCCESS("200","成功"), WRONG_REQUEST("400","请求的格式有误"),
    NEED_VERIFY("401","需要登录验证"), BANNED("403","该链接已禁止访问"),
    NOT_FOUND("404","未找到页面"), SERVER_ERROR("500","服务器错误");

    private String code;
    private String message;

    CommonResultEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
