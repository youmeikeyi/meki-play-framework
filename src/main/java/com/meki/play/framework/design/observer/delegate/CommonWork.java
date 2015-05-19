package com.meki.play.framework.design.observer.delegate;

/**
 * 委托工作的类
 * 什么也不做
 * Created by xujinchao on 2015/5/19.
 */
public class CommonWork {

    IWorkDelegate delegate = null;

    public CommonWork(IWorkDelegate delegate){
        this.delegate = delegate;
    }

    public long getStartTime(){
        long startTime = delegate.startTime();
        return startTime;
    }

    public long getEndTime(){
        long endTime = delegate.endTime();
        return endTime;
    }

    public void beginWork(){
        delegate.work();
    }
}
