package com.wt.service;

import com.wt.dao.entity.SysPerm;

import java.util.List;

public interface SysPermService {

    /**
     * 查询用户的权限
     * @param userName 用户名
     * @return 用户权限集合
     */
    List<SysPerm> findUserPermByUserName(String userName);
}
