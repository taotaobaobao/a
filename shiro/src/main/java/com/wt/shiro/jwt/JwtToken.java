package com.wt.shiro.jwt;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/8 1:39 下午
 * @description：
 */
@Data
public class JwtToken implements AuthenticationToken {


    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
