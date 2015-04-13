package com.meki.play.framework.design.factory.abs;

/**
 * Created by user on 2015/4/10.
 */
public class ConcreteFactoryB extends AbstractFactory {

    @Override
    protected AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    protected AbstractProductB createProductB() {
        return new ProductB2();
    }
}
