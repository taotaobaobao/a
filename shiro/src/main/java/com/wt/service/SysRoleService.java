package com.wt.service;

import com.wt.constant.Result;
import com.wt.dao.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    /**
     * 查询用户所拥有的角色
     * @param userName 用户名
     * @return 用户拥有的角色集合
     */
     List<SysRole> findUserRole(String userName);

    /**
     * 查询所有的角色列表
     * @return 角色集合
     */
    Result<List<SysRole>> findAllRole();
}
