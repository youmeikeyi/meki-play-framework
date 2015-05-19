package com.meki.play.framework.design.observer;

/**
 * 通知者接口
 * 相当于被观察者
 * Created by xujinchao on 2015/5/18.
 */
public interface IObservable {

    public void attach(IObserver observer);

    public void detach(IObserver observer);

    public void notifyObservers();


    public void setSubjectStatus(String subjectStatus);

    public String getSubjectStatus();
}
