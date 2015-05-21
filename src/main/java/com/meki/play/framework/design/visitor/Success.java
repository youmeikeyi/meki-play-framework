package com.meki.play.framework.design.visitor;

/**
 * Created by xujinchao on 2015/5/21.
 */
public class Success extends Action {

    @Override
    public void getManConclusion(Man man) {
        System.out.println(String.format("%s %s时, blabla", man.name, this.getClass().getName()));
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println(String.format("%s %s时, blabla", woman.name, this.getClass().getName()));
    }
}
