package com.wt.service;

import com.wt.constant.Result;
import com.wt.dao.entity.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> findAllUser();

    /**
     * 根据用户名查询用户
     * @param userName 用户名
     * @return
     */
    SysUser findUserByUserName(String userName);

    /**
     * 登陆接口
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    Result<String> login(String userName, String password);

}
