package com.wt.controller;

import com.wt.pull.MyEventListener;
import com.wt.push.MyEventPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wt
 * @date ：Created in 2022/3/27 12:32 下午
 * @description：1.0
 * @version: 1.0$
 */
@RestController
public class Demo {

    @Autowired
    private MyEventPush myEventPush;


    @RequestMapping(value = "/test/testPublishEvent1" )
    public Map<String,String> test(){
        myEventPush.push();
        Map<String,String> map=new HashMap<>();
        map.put("code","0");
        return map;
    }

}
