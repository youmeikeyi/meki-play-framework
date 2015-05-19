package com.meki.play.framework.design.observer;

/**
 * 具体观察者耦合了抽象主题
 * 事件委托模型 可将不同类型的观察者表现不同
 * Created by xujinchao on 2015/5/19.
 */
public class Test {

    public static void main(String[] args){
        Boss boss = new Boss();

        boss.attach(new StockObserver("X", boss));
        boss.attach(new StockObserver("Y", boss));

        boss.setSubjectStatus("老板回来了");
        boss.notifyObservers();
    }
}
