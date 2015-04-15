package com.meki.play.framework.design.factory.abs;

/**
 * 抽象工厂总类  也可设计为接口,如IFactory
 * Created by user on 2015/4/10.
 */
public abstract class AbstractFactory {

    protected abstract AbstractProductA createProductA();
    protected abstract AbstractProductB createProductB();
}
