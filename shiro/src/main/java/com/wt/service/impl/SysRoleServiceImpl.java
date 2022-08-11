package com.wt.service.impl;

import com.wt.constant.Result;
import com.wt.dao.entity.SysRole;
import com.wt.dao.mapper.SysRoleMapper;
import com.wt.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/8 4:25 下午
 * @description：
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;


    /**
     * 查询用户所拥有角色
     *
     * @param userName 用户名
     * @return 用户拥有的角色集合
     */
    @Override
    public List<SysRole> findUserRole(String userName) {
        return sysRoleMapper.findUserNameRoleByUserName(userName);
    }


    /**
     * 查询所有的角色列表
     *
     * @return 角色集合
     */
    @Override
    public Result<List<SysRole>> findAllRole() {
        List<SysRole> sysRoleList = sysRoleMapper.findAllRole();
        sysRoleList.removeIf(next -> "admin".equals(next.getSrKey()));
        return Result.success(sysRoleList);
    }
}
