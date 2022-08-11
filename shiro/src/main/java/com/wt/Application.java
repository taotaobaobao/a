package com.wt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 11:54 上午
 * @description：
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        System.out.println("启动成功～");
    }



}
