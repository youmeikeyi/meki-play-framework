package com.meki.play.framework.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的通知者类
 * Created by xujinchao on 2015/5/18.
 */
public class Boss implements IObservable {

    private String status = "Boss is coming back";

    public List<IObserver> observerList = new ArrayList<IObserver>();

    @Override
    public void attach(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observerList) {
            observer.update();
        }
    }

    @Override
    public void setSubjectStatus(String subjectStatus) {
        this.status = subjectStatus;
    }

    @Override
    public String getSubjectStatus() {
        return status;
    }

    public List<IObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<IObserver> observerList) {
        this.observerList = observerList;
    }
}
