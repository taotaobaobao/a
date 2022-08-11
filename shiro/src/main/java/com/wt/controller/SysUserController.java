package com.wt.controller;

import com.wt.constant.Result;
import com.wt.dao.entity.SysUser;
import com.wt.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 2:54 下午
 * @description: 用户的controller
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;


    /**
     * 登陆接口
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    @PostMapping("/login")
    public Result<String> login(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return sysUserService.login(userName,password);
    }

    @RequiresPermissions("system:role:list")
    @GetMapping("/findAllUser")
    public Result<List<SysUser>> findAllUser(){
        List<SysUser> userList = sysUserService.findAllUser();
        return Result.success(userList);
    }

    /**
     * 添加用户和角色和权限
     * @return
     */
    public Result<Boolean> page(){

        return null;
    }




}
