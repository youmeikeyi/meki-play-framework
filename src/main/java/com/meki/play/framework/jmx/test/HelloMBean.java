package com.meki.play.framework.jmx.test;

/**
 * Created by xujinchao on 2015/5/5.
 */
public interface HelloMBean {

    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String who);
}
