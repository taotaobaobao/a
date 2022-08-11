package com.wt;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：shan zha
 * @date ：Created in 2022/5/4 1:58 下午
 * @description：权限框架
 */
@SpringBootApplication
public class SaTokenSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenSpringApplication.class);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }


}
