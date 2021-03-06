package com.meki.play.framework.design.factory.method;

/**
 * 为每种类型的产品创建工厂
 * Created by user on 2015/4/10.
 */
public class CommonUserFactory implements IFactory {

    @Override
    public IUser createUser() {
        return new CommonUser();
    }

    @Override
    public IDepartment addDepartment() {
        return null;
    }
}
