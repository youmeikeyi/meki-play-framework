package com.meki.play.framework.design.observer;

/**
 * 具体观察者
 * Created by xujinchao on 2015/5/18.
 */
public class StockObserver implements IObserver {

    private String name;
    private IObservable IObservable;
    public StockObserver(String name, IObservable IObservable){
        this.name = name;
        this.IObservable = IObservable;
    }

    @Override
    public void update() {
        String message = String.format("%s, %s close the stock", this.IObservable.getSubjectStatus(), name);
        System.out.println(message);
    }
}
