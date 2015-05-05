package com.meki.play.framework.jmx.test;

/**
 * Created by xujinchao on 2015/5/5.
 */
public class Hello implements HelloMBean {
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("Hello~!");
    }

    @Override
    public void printHello(String who) {
        System.out.println("Hello, " + who + "!");
    }
}
