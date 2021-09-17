package com.demo.util;

import com.demo.config.JwtConfig;
import javax.servlet.http.HttpServletRequest;

public class ParamUtil {
    static JwtConfig jwtConfig = new JwtConfig("abcdefg1234567", 3600, "token");

    /*获取登录用户的uid*/
    public static String getUserId(HttpServletRequest request){
        /*
        String token = request.getHeader("token");
        String userId = jwtConfig.getTokenClaim(token).getSubject();
        return userId;
        */
        //测试时，不使用jwt,返回固定uerId
        return "237fd7e7ee414834bc6f6f8a6680f632";
    }
}
