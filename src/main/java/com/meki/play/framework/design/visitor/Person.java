package com.meki.play.framework.design.visitor;

/**
 * 对象抽象类
 * Created by xujinchao on 2015/5/21.
 */
public abstract class Person {
    public abstract void accept(Action visitor);
}
