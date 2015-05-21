package com.meki.play.framework.design.visitor;

/**
 * Created by xujinchao on 2015/5/21.
 */
public class Man extends Person {

    public final static String name = "Man";
    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }
}
