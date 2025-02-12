package com.example.patientmange.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtCreate {
    //生成JWT
    //7天过期
    private static long expire = 604800;
    //32位密钥
    private static String secret = "3f63cd1d07d17950ad08203f065a28ee48d61a4b0384dca3716735e2b3c6d18cb306dd89ff4ae2d117222f7db37a7ab71f3aafa1d490371aecdf35590e550019\n";

    //生成token函数
    public static String generateToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime()+ 1000 *expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,secret)//指定签名算法
                .compact();
    }

    //解析token
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
