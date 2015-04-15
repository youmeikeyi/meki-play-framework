package com.meki.play.framework.design.factory.method;

import com.meki.play.framework.design.bean.User;

/**
 * Created by user on 2015/4/10.
 */
public class CommonUser implements IUser {

    @Override
    public int insertUser(User user) {
        return 1;
    }

    @Override
    public User getUser() {
        return null;
    }

}
