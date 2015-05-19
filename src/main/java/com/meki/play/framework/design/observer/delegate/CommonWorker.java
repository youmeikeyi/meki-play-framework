package com.meki.play.framework.design.observer.delegate;

/**
 * 委托工作
 * Created by xujinchao on 2015/5/19.
 */
public class CommonWorker implements IWorkDelegate {

    @Override
    public void work() {
        System.out.println(getClass().getName() + " begin work");
    }

    @Override
    public long endTime() {
        return System.currentTimeMillis() + 1000000;
    }

    @Override
    public long startTime() {
        return System.currentTimeMillis();
    }
}
