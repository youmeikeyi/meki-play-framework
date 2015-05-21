package com.meki.play.framework.design.visitor;

/**
 * 访问者 visitor
 * 当需要新的处理操作时，只需定义新的Action
 * 当数据结构不稳定时，不适合用
 * Created by xujinchao on 2015/5/21.
 */
public abstract class Action {

    public abstract void getManConclusion(Man man);

    public abstract void getWomanConclusion(Woman woman);
}
