package com.wt.service.impl;

import com.wt.service.FruitService;
import org.springframework.stereotype.Service;

/**
 * @author ：shan zha
 * @date ：Created in 2022/5/24 10:07 上午
 * @description：西瓜
 */
@Service
public class FruitWatermelonServiceImpl implements FruitService {
    @Override
    public void eat() {
        System.out.println("我喜欢吃西瓜");
    }
}
