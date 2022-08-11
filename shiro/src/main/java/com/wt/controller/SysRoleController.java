package com.wt.controller;

import com.wt.constant.Result;
import com.wt.dao.entity.SysRole;
import com.wt.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/14 2:35 下午
 * @description：角色controller
 */
@RequestMapping("/sysRole")
@RestController
public class SysRoleController {


    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/findAllRole")
    @RequiresRoles("admin")
    public Result<List<SysRole>> findAllRole(){
        return sysRoleService.findAllRole();
    }

}
