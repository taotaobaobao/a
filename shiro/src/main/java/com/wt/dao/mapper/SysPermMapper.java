package com.wt.dao.mapper;

import com.wt.dao.entity.SysPerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 2:08 下午
 * @description：
 */
@Mapper
public interface SysPermMapper {

    /**
     * 查询用户所拥有的权限
     * @param userName 用户名
     * @return
     */
    List<SysPerm> findUserPermByUserName(@Param("userName") String userName);
}
