package com.javaee.support.utils;

import com.javaee.common.constants.ClassroomConstants;
import com.javaee.support.constants.SupportConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.javaee.support.constants.SupportConstants.EXPIRE;
import static com.javaee.support.constants.SupportConstants.SIGN_KEY;

/**
 * @author nia
 * @description JWT工具类
 * @Date 2024/6/13
 */

public class JWTUtil {


    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分负载payload中存储的内容
     * @return jwt令牌
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .compact();
    }

    public static String generateJsonJwt(String id){
        Map<String,Object> map = new HashMap<>();
        map.put(SupportConstants.ID,id);
        return generateJwt(map);
    }


    /**
     * 解析JWT令牌
     *
     * @param jwt jwt令牌
     * @return JWT第二部分负载payload中存储的内容
     */
    public static Claims parseJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static String getId(String jwt) {
        Claims claims = parseJwt(jwt);
        return (String) claims.get("id");
    }


}

