package com.wt.dao.mapper;

import com.wt.dao.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {


    List<SysUser> findAll();


    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    SysUser findUserByUserName(@Param("userName")String userName);
}
