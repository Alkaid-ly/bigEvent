package com.itcast;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/15 23:10
 * @Version: 1.0
 * @Description:非对称式加密令牌测试
 */
public class JwtTest {
    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))//添加过期时间
                .sign(Algorithm.HMAC256("itcast"));//指定算法，配置密匙
        System.out.println(token);
    }
    @Test
    public void testParse(){
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleH" +
                "AiOjE3MDUzNzU2MDUsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5by" +
                "g5LiJIn19.dDtLqq0mOAW4q3mUM_qTAAlPdjq7OnzgyaCP4Eu0qZk";
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("itcast")).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        Map<String, Claim> claims=decodedJWT.getClaims();
        System.out.println(claims.get("user"));

    }
//    验证失败
//    token过期
}
