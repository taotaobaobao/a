package com.wt.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author ：shan zha
 * @date ：Created in 2022/5/4 2:02 下午
 * @description：用户登陆
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String doLogin(String username,String password){
        if("zhangsan".equals(username)&&"123456".equals(password) ){
            StpUtil.login(10001);
            StpUtil.login(10002);
            return "登陆成功";
        }
        return "登陆失败";
    }

    // 登录认证：只有登录之后才能进入该方法
    @SaCheckLogin
    @RequestMapping("info")
    public String info() {
        return "查询用户信息";
    }


    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin()+"当前登陆人："+StpUtil.getLoginIdAsString();
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }


    //加密
    @RequestMapping("/encode")
    public String encode() throws Exception {
        HashMap<String, String> stringStringHashMap = SaSecureUtil.rsaGenerateKeyPair();
        String privateKey = stringStringHashMap.get("private");
        String publicKey = stringStringHashMap.get("public");
        String text="王涛加密";
        String ciphertext = SaSecureUtil.rsaEncryptByPublic(publicKey, text);
        String s = SaSecureUtil.rsaDecryptByPrivate(privateKey, ciphertext);

        // 定义私钥和公钥
        String privateKey1 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAO+wmt01pwm9lHMdq7A8gkEigk0XKMfjv+4IjAFhWCSiTeP7dtlnceFJbkWxvbc7Qo3fCOpwmfcskwUc3VSgyiJkNJDs9ivPbvlt8IU2bZ+PBDxYxSCJFrgouVOpAr8ar/b6gNuYTi1vt3FkGtSjACFb002/68RKUTye8/tdcVilAgMBAAECgYA1COmrSqTUJeuD8Su9ChZ0HROhxR8T45PjMmbwIz7ilDsR1+E7R4VOKPZKW4Kz2VvnklMhtJqMs4MwXWunvxAaUFzQTTg2Fu/WU8Y9ha14OaWZABfChMZlpkmpJW9arKmI22ZuxCEsFGxghTiJQ3tK8npj5IZq5vk+6mFHQ6aJAQJBAPghz91Dpuj+0bOUfOUmzi22obWCBncAD/0CqCLnJlpfOoa9bOcXSusGuSPuKy5KiGyblHMgKI6bq7gcM2DWrGUCQQD3SkOcmia2s/6i7DUEzMKaB0bkkX4Ela/xrfV+A3GzTPv9bIBamu0VIHznuiZbeNeyw7sVo4/GTItq/zn2QJdBAkEA8xHsVoyXTVeShaDIWJKTFyT5dJ1TR++/udKIcuiNIap34tZdgGPI+EM1yoTduBM7YWlnGwA9urW0mj7F9e9WIQJAFjxqSfmeg40512KP/ed/lCQVXtYqU7U2BfBTg8pBfhLtEcOg4wTNTroGITwe2NjL5HovJ2n2sqkNXEio6Ji0QQJAFLW1Kt80qypMqot+mHhS+0KfdOpaKeMWMSR4Ij5VfE63WzETEeWAMQESxzhavN1WOTb3/p6icgcVbgPQBaWhGg==";
        String publicKey1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDvsJrdNacJvZRzHauwPIJBIoJNFyjH47/uCIwBYVgkok3j+3bZZ3HhSW5Fsb23O0KN3wjqcJn3LJMFHN1UoMoiZDSQ7PYrz275bfCFNm2fjwQ8WMUgiRa4KLlTqQK/Gq/2+oDbmE4tb7dxZBrUowAhW9NNv+vESlE8nvP7XXFYpQIDAQAB";

// 文本
        String text1 = "Sa-Token 一个轻量级java权限认证框架";

// 使用公钥加密
        String ciphertext1 = SaSecureUtil.rsaEncryptByPublic(publicKey1, text1);
        System.out.println("公钥加密后：" + ciphertext);

// 使用私钥解密
        String text2 = SaSecureUtil.rsaDecryptByPrivate(privateKey1, ciphertext1);
        System.out.println("私钥解密后：" + text2);

        return "加密:"+ciphertext+"   解密:"+s;
    }


    @RequestMapping(value = "{value}",method = RequestMethod.GET)
    public String demo(String value,String values2){
//        String fileDir="/Users/wangtao";
//        String path = this.getClass().getResource("/robots.txt").getPath();
//        String robots = FileUtil.readUtf8String(new File(path));
//        String robotsTxt = StrUtil.format("{}/{}", fileDir, "robots.txt");
//        File robotsTxtFile = FileUtil.writeBytes(robots.getBytes(StandardCharsets.UTF_8), robotsTxt);
//        return robotsTxtFile.getName();
        return value;
    }

}
