package com.meki.play.framework.design.observer.delegate;

/**
 * 委托和回调
 * Created by xujinchao on 2015/5/19.
 */
public class Test {

    public static void main(String[] args) {
        CommonWork commonWork = new CommonWork(new CommonWorker());
        commonWork.beginWork();
//        new CommonWorker().work();
    }
}
