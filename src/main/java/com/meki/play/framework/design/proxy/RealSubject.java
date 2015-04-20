package com.meki.play.framework.design.proxy;

/**
 * Created by user on 2015/4/16.
 */
public class RealSubject implements Subject {

    @Override
    public String sayHello(String name, int age) {
        return name + "  " + age;
    }

}
