package com.wt.shiro.jwt;


import com.wt.unified.RedisPrefix;
import com.wt.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/15 10:40 上午
 * @description：刷新token工具类
 */
public class TokenRefreshUtil {

    /**
     * 1 从redis获取token,获取的token判断token是否过期
     * 2 过期了token，重新生产一个token，在往redis里面设置
     * 3 jwt的token为2小时，redis里面的token是jwt的2倍
     * @return
     */
    public static boolean tokenRefresh(String token,String userName,String password){
        String cacheToken = RedisUtils.get(RedisPrefix.TOKEN_AUTHORIZATION.concat(":").concat(token));//第一次的token
        //redis里面的token不存在,直接返回
        if(StringUtils.isBlank(cacheToken)){
            return false;
        }
        //校验token的真实性
        boolean verify = JwtUtil.verify(token, userName, password);
        if (!verify) {
            String newToken = JwtUtil.createSign(userName, password);
            //设置新的token在redis里面
            RedisUtils.set(RedisPrefix.TOKEN_AUTHORIZATION.concat(":").concat(token),newToken,JwtUtil.refreshExpire);
        }
        return true;
    }
}
