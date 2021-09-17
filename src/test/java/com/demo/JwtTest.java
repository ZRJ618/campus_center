package com.demo;

import com.demo.config.JwtConfig;
import org.junit.jupiter.api.Test;

public class JwtTest {
    @Test
    void testAllMethod(){
        JwtConfig jwtConfig = new JwtConfig();
        String token = jwtConfig.createToken("123");
        //System.out.println(jwtConfig.getTokenClaim(token));
    }
}
