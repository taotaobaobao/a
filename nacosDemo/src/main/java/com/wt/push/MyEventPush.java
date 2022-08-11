package com.wt.push;

import com.wt.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ：wt
 * @date ：Created in 2022/3/27 12:24 下午
 * @description：1.0
 * @version: 1.0$
 */
@Component
public class MyEventPush {

    @Autowired
    private ApplicationContext applicationContext;


    public void push(){
        applicationContext.publishEvent(new UserDAO(this,"wangtao","23"));
    }

}
