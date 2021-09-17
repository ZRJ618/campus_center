package com.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "config.jwt")
@AllArgsConstructor
@NoArgsConstructor

/*jwt配置类*/
public class JwtConfig {
    private String secret;
    private long expire;
    private String header;

    /*创建token命令*/
    public String createToken(String subject){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 10000);
        /*iss (issuer)：签发人
          exp (expiration time)：过期时间
          sub (subject)：主题
          aud (audience)：受众
          nbf (Not Before)：生效时间
          iat (Issued At)：签发时间
          jti (JWT ID)：编号
          */
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")//设置响应头
                .setSubject(subject)//所有者
                .setIssuedAt(nowDate)//签发者
                .setExpiration(expireDate)//设置过期时间
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        /*HMAC SHA256(
            base64UrlEncode(header) + "." +
            base64UrlEncode(payload),
            secret)*/
    }
    /*获取token中注册信息*/
    public Claims getTokenClaim(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*验证token是否失效
    * 返回值为true代表过期*/
    public boolean isTokenExpired(Date expirationTime){
        //如果给定的值早于现在的值 则返回true
        return expirationTime.before(new Date());
    }

    /*获取token的失效时间*/
    public Date getExpirationDateFromToken(String token){
        return getTokenClaim(token).getExpiration();
    }

    /*获取jwt发布时间*/
    public Date getIssueAtDateFromToken(String token){
        return getTokenClaim(token).getIssuedAt();
    }
}
