package com.meki.play.framework.design.observer.delegate;

/**
 * 委托接口
 * Created by xujinchao on 2015/5/19.
 */
public interface IWorkDelegate {

    public abstract long startTime();

    public abstract long endTime();

    public abstract void work();
}
