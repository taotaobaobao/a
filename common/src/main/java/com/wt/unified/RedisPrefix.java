package com.wt.unified;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/9 2:48 下午
 * @description：redis统一前缀
 */
public interface RedisPrefix {

    /** 用户登陆密码错误超过5次 **/
    String USER_PASSWORD_ERROR_PREFIX="USER_PASSWORD_ERROR_PREFIX";

    /** 验证TOKEN是否在redis存在 **/
    String TOKEN_AUTHORIZATION="TOKEN_AUTHORIZATION";

}
