package com.wt.constant;

import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/8 10:24 上午
 * @description： 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public Result<String> bizExceptionHandler(BizException e) {
        return Result.error(ResultCodeEnum.ERROR,e.getMes());
    }


    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(Exception e) {
        log.error("发生异常信息:", e);
        return  Result.error(ResultCodeEnum.ERROR, "系统异常");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<String> notSupported(HttpRequestMethodNotSupportedException ex) {
        log.error("HttpRequestMethodNotSupportedException:", ex);
        return Result.error(ResultCodeEnum.ERROR,ex.getMessage());
    }

    /** shiro无权限异常 **/
    @ExceptionHandler(value = AuthorizationException.class)
    public Result<String> exceptionShiroHandler(AuthorizationException ae){
        log.error("AuthorizationException:",ae);
        return  Result.error(ResultCodeEnum.USER_NO_PERMISSION, ae.getMessage());
    }

}
