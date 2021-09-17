package com.demo.config;


import com.demo.exception.GlobalException;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private JwtConfig jwtConfig;

    /*jwt拦截器配置*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        //判断uri反行登录界面
        if(uri.contains("/login")){
            System.out.println("登录请求");
            return true;
        }
        if(uri.contains("/register")) {
            System.out.println("注册请求");
            return true;
        }
        if(uri.contains("/activation")) {
            System.out.println("激活请求");
            return true;
        }
        /*token验证*/
        String token = request.getHeader(jwtConfig.getHeader());
        if(token == null){
            token = request.getParameter(jwtConfig.getHeader());
        }
        if(token == null){
            throw new GlobalException("500", jwtConfig.getHeader() + "不能为空");
        }
        Claims claims = null;
        //时间过期验证
        try{
            claims = jwtConfig.getTokenClaim(token);
            if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
                throw new GlobalException("500", jwtConfig.getHeader() + "失效，请重新登录");
            }
        }catch(Exception e){
            throw new GlobalException("500", jwtConfig.getHeader() + "失效，请重新登录");
        }
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }

}
