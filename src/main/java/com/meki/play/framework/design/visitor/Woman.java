package com.meki.play.framework.design.visitor;

/**
 * 具体对象
 * Created by xujinchao on 2015/5/21.
 */
public class Woman extends Person {

    public final static String name = "Woman";

    @Override
    public void accept(Action visitor) {
        visitor.getWomanConclusion(this);
    }
}
