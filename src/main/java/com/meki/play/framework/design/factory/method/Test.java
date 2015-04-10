package com.meki.play.framework.design.factory.method;

import com.meki.play.framework.design.bean.User;

/**
 * Created by user on 2015/4/10.
 */
public class Test {

    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setName("xx");
        user.setPwd("***");

        IFactory factory = new CommonUserFactory();
        IUser iUser = factory.createUser();
        iUser.insertUser(user);
    }
}
