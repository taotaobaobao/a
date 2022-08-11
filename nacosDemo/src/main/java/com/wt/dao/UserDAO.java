package com.wt.dao;

import org.springframework.context.ApplicationEvent;

/**
 * @author ：wt
 * @date ：Created in 2022/3/27 12:12 下午
 * @description：1.0
 * @version: 1.0$
 */
public class UserDAO extends ApplicationEvent {

    private String username;

    private String age;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDAO(Object source, String username, String age) {
        super(source);
        this.username = username;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    public UserDAO(Object source) {
        super(source);
    }




    @Override
    public String toString() {
        return "UserDAO{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
