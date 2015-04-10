package com.meki.play.framework.design.factory.method;

/**
 * Created by user on 2015/4/10.
 */
public class CommonUserFactory implements IFactory {

    @Override
    public IUser createUser() {
        return new CommonUser();
    }
}
