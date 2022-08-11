package com.wt.dao.mapper;

import com.wt.dao.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper {


    /**
     * 根据用户名查询用户的角色
     * @param userName
     * @return 用户角色集合
     */
    List<SysRole> findUserNameRoleByUserName(@Param("userName") String userName);

    /**
     * 查询所有的角色列表
     * @return 角色集合
     */
    List<SysRole> findAllRole();

}
