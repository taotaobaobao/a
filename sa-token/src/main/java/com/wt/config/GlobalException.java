package com.wt.config;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shan zha
 * @date ：Created in 2022/5/5 5:38 下午
 * @description：全局拦截器
 */
@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> handlerException(Exception e, HttpServletRequest request, HttpServletResponse response){
        System.out.println("全局异常处理-----------");
        e.printStackTrace();
        Map<String,Object> errorMap=new HashMap<>();
        if (e instanceof NotLoginException) {	// 如果是未登录异常
            NotLoginException ee = (NotLoginException) e;
            System.out.println("异常原因{"+ee+"}");
            errorMap.put("code","-1");
            errorMap.put("date",new Date());
            errorMap.put("mes","当前账户未登陆");
        }
        else if(e instanceof NotRoleException) {		// 如果是角色异常
            NotRoleException ee = (NotRoleException) e;
            System.out.println("异常原因{"+ee+"}");
            errorMap.put("code","-2");
            errorMap.put("date",new Date());
            errorMap.put("mes","当前账户异常");
        }
        else if(e instanceof NotPermissionException) {	// 如果是权限异常
            NotPermissionException ee = (NotPermissionException) e;
            System.out.println("异常原因{"+ee+"}");
            errorMap.put("code","-3");
            errorMap.put("date",new Date());
            errorMap.put("mes","当前账户权限不足");
        }
        else if(e instanceof DisableLoginException) {	// 如果是被封禁异常
            DisableLoginException ee = (DisableLoginException) e;
            System.out.println("异常原因{"+ee+"}");
            errorMap.put("code","-4");
            errorMap.put("date",new Date());
            errorMap.put("mes","当前账户被封禁,请["+ee.getDisableTime()+"]秒后解封");
        }
        return errorMap;
    }
}
