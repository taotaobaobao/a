package com.wt.shiro.realm;

import com.wt.constant.BizException;
import com.wt.constant.ResultCodeEnum;
import com.wt.dao.entity.SysPerm;
import com.wt.dao.entity.SysRole;
import com.wt.dao.entity.SysUser;
import com.wt.service.SysPermService;
import com.wt.service.SysRoleService;
import com.wt.service.SysUserService;
import com.wt.shiro.jwt.JwtToken;
import com.wt.shiro.jwt.JwtUtil;
import com.wt.shiro.jwt.TokenRefreshUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/8 4:01 下午
 * @description：
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermService sysPermService;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 执行用户的授权和角色信息
     *
     * @param principalCollection token
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String token = (String) principalCollection.getPrimaryPrincipal();
        String userName = JwtUtil.getUserName(token);
        if (StringUtils.isEmpty(userName)) {
            throw new BizException(ResultCodeEnum.INVALID_TOKEN);
        }
        //查询数据库获取用户的权限和角色
        List<SysRole> userRole = sysRoleService.findUserRole(userName);
        Set<String> role = userRole.stream().map(SysRole::getSrKey).collect(Collectors.toSet());
        List<SysPerm> userPerm = sysPermService.findUserPermByUserName(userName);
        Set<String> perm = userPerm.stream().map(SysPerm::getSpKey).collect(Collectors.toSet());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (CollectionUtils.isNotEmpty(role)) {
            authorizationInfo.addRoles(role);
        }
        if (CollectionUtils.isNotEmpty(perm)) {
            authorizationInfo.addStringPermissions(perm);
        }
        return authorizationInfo;
    }

    /**
     * 执行用户登陆信息
     *
     * @param authenticationToken token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String userName = JwtUtil.getUserName(token);
        if (StringUtils.isEmpty(userName)) {
            throw new BizException(ResultCodeEnum.INVALID_TOKEN);
        }
        //查询用户是否存在
        SysUser sysUser = sysUserService.findUserByUserName(userName);
        if (sysUser == null) {
            throw new BizException(ResultCodeEnum.USER_DOES_NOT_EXIST);
        }
        //校验token真实性，判断token是否过期。如果过期刷新token
        if(!TokenRefreshUtil.tokenRefresh(token,sysUser.getSuName(),sysUser.getSuPassword())){
            throw new BizException(ResultCodeEnum.USER_DOES_NOT_EXIST);
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }

}
