package com.meki.play.framework.design.factory.method;

import com.meki.play.framework.design.factory.method.IUser;

/**
 * Created by user on 2015/4/10.
 */
public class CommonUser implements IUser {

    @Override
    public int insertUser(IUser user) {
        return 1;
    }

    @Override
    public IUser getUser() {
        return null;
    }
}
