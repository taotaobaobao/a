package com.wt.controller;

import com.wt.service.FruitService;
import com.wt.service.impl.FruitBananaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ：shan zha
 * @date ：Created in 2022/5/24 10:13 上午
 * @description：
 */
@RestController
public class FruitController {

    @Autowired
    List<FruitService> fruitService;

    @Resource
    Map<String, FruitService> fruitServiceFruitServiceMap;


    @GetMapping("/fruitList")
    public void fruitList() {
        for (FruitService service : fruitService) {
            System.out.println(service);
            service.eat();
        }
    }

    @GetMapping("/fruitMap")
    public void fruitMap() {
        fruitServiceFruitServiceMap.forEach((x, y) -> y.eat());
        for (String s : fruitServiceFruitServiceMap.keySet()) {
            System.out.println(s);
        }
    }

}
