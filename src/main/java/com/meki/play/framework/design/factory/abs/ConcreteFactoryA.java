package com.meki.play.framework.design.factory.abs;

/**
 * Created by user on 2015/4/10.
 */
public class ConcreteFactoryA extends AbstractFactory {

    @Override
    protected AbstractProductB createProductB() {
        return new ProductB();
    }

    @Override
    protected AbstractProductA createProductA() {
        return new ProductA();
    }
}
