package com.wt.service.impl;

import com.wt.service.FruitService;
import org.springframework.stereotype.Service;

/**
 * @author ：shan zha
 * @date ：Created in 2022/5/24 10:06 上午
 * @description：苹果
 */
@Service
public class FruitAppleServiceImpl implements FruitService {
    @Override
    public void eat() {
        System.out.println("我喜欢吃苹果");
    }
}
