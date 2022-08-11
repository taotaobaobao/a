package com.wt.shiro.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/8 1:51 下午
 * @description：
 */
@Slf4j
public class JwtUtil {

    //过期时间
    private final static Long expire = 30 * 60 * 1000L;

    //刷新token时间
    final static Long refreshExpire = 30 * 60 * 1000L * 2;

    //密钥
    private final static String secret = "shiro";

    /**
     * 创建token
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回一个token
     */
    public static String createSign(String userName, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password + secret);
            Date date = new Date(System.currentTimeMillis() + expire);

            return JWT.create().withClaim("userName", userName).
                    withClaim("password", password).
                    withExpiresAt(date).
                    sign(algorithm);
        } catch (Exception e) {
            log.error("生产签名错误:", e);
            return null;
        }
    }

    /**
     * 验证token是否存在
     *
     * @param token    token
     * @param userName 用户名
     * @param password 密码
     * @return 返回
     */
    public static boolean verify(String token, String userName, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password + secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userName", userName)
                    .withClaim("password", password)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error("验证签名错误:", e);
            return false;
        }
    }

    /**
     * 获取token的用户名
     *
     * @param token token
     * @return
     */
    public static String getUserName(String token) {
        try {
            return JWT.decode(token).getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            log.error("根据token获取用户名失败:", e);
            return null;
        }
    }

    /**
     * 获取token的密码
     *
     * @param token token
     * @return
     */
    public static String getPassword(String token) {
        try {
            return JWT.decode(token).getClaim("password").asString();
        } catch (JWTDecodeException e) {
            log.error("根据token获取密码失败:", e);
            return null;
        }
    }


}
