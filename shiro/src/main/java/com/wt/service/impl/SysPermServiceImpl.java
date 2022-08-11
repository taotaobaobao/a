package com.wt.service.impl;

import com.wt.dao.entity.SysPerm;
import com.wt.dao.mapper.SysPermMapper;
import com.wt.service.SysPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/8 5:11 下午
 * @description：
 */
@Service
public class SysPermServiceImpl implements SysPermService {

    @Autowired
    private SysPermMapper sysPermMapper;


    /**
     * 查询用户的权限
     * @param userName 用户名
     * @return 用户权限集合
     */
    @Override
    public List<SysPerm> findUserPermByUserName(String userName) {
        return sysPermMapper.findUserPermByUserName(userName);
    }
}
