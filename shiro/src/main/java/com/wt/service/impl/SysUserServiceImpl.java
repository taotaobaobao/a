package com.wt.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.wt.constant.Result;
import com.wt.dao.entity.SysUser;
import com.wt.dao.mapper.SysUserMapper;
import com.wt.service.SysUserService;
import com.wt.shiro.jwt.JwtUtil;
import com.wt.unified.RedisPrefix;
import com.wt.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 2:56 下午
 * @description：
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    /**
     * 密码半小时内只能错误5次
     **/
    private static final int TIMES_CHECK_INPUT_PASSWORD_NUM = 5;

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public List<SysUser> findAllUser() {
        return sysUserMapper.findAll();
    }

    @Override
    public SysUser findUserByUserName(String userName) {
        return sysUserMapper.findUserByUserName(userName);
    }

    /**
     * 登陆接口
     *
     * @param userName 用户名
     * @param password 密码
     * @return token
     */
    @Override
    public Result<String> login(String userName, String password) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return Result.error("请输入用户名和密码");
        }
        SysUser sysUser = this.findUserByUserName(userName);
        if (sysUser == null) {
            return Result.error("该用户不存在");
        }
        //密码md5加密
        String suPassword = sysUser.getSuPassword();
        String passwordMd5 = DigestUtil.md5Hex(password);
        //半小时内密码连续错误5次,等待半小时在输入
        if (!passwordMd5.equals(suPassword)) {
            int passwordFailCount = 0;
            String key = RedisPrefix.USER_PASSWORD_ERROR_PREFIX.concat(":").concat(sysUser.getSuName());
            if (RedisUtils.hasKey(key)) { //如果key存在
                passwordFailCount = RedisUtils.get(key);
            }
            if (passwordFailCount > TIMES_CHECK_INPUT_PASSWORD_NUM) {
                return Result.error("密码连续错误5次,过半小时在登陆");
            }
            passwordFailCount++;
            RedisUtils.set(key, passwordFailCount, 1800);//半小时失效
            if (passwordFailCount == 4) {
                return Result.error("密码错误,你还剩下最后一次输入密码");
            }
            return Result.error("密码错误");
        }
        //这里创建jwt用的密码是加密后的
        String sign = JwtUtil.createSign(sysUser.getSuName(), passwordMd5);
        return Result.success(sign);
    }
}
