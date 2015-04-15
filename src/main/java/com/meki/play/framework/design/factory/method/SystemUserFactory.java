package com.meki.play.framework.design.factory.method;

/**
 * Created by user on 2015/4/15.
 */
public class SystemUserFactory implements IFactory {

    @Override
    public IUser createUser() {
        return new SystemUser();
    }

    @Override
    public IDepartment addDepartment() {
        return null;
    }
}
