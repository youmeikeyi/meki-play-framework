package com.meki.play.framework.design.factory.method;

import com.meki.play.framework.design.bean.User;

/**
 * Created by user on 2015/4/10.
 */
public interface IUser {

    public int insertUser(User user);
    public User getUser();
}
