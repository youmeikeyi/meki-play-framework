package com.meki.play.framework.design.observer;

/**
 * 观察者接口
 * 也可使用抽象类，但有时观察者不具备子类关系
 * Created by xujinchao on 2015/5/18.
 */
public interface IObserver {

    public void update();
}
