package com.wt.pull;

import com.wt.dao.UserDAO;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ：wt
 * @date ：Created in 2022/3/27 12:18 下午
 * @description：1.0
 * @version: 1.0$
 */
@Component
public class MyEventListener{


    @EventListener(classes = UserDAO.class)
    public void onApplicationEvent(UserDAO userDAO) {
        String username = userDAO.getUsername();
        String age = userDAO.getAge();
        System.out.println("userName:"+username+"====AGE:"+age);
    }
}
