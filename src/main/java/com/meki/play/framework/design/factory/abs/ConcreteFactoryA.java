package com.meki.play.framework.design.factory.abs;

/**
 * Created by user on 2015/4/10.
 */
public class ConcreteFactoryA extends AbstractFactory {

    @Override
    protected ProductB createProductB() {
        return new ProductB();
    }

    @Override
    protected ProductA createProductA() {
        return new ProductA();
    }
}
