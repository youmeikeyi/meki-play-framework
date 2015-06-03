package com.meki.play.framework.design.responsibility;

/**
 * Created by xujinchao on 2015/5/18.
 */
public abstract class InvocationProcessHandler {

    public InvocationProcessHandler nextHandler;

    public void setNextHandler(InvocationProcessHandler handler){
        this.nextHandler = handler;
    }

    /**
     * 是否可处理该请求
     * @param request
     * @return
     */
    public abstract boolean canAccept(InvocationRequest request);

    /**
     * 请求处理方法  可将是否可处理的判断放进来
     * @param request
     * @return
     */
    public abstract InvocationRequest process(InvocationRequest request);

    public InvocationProcessHandler next() {
        return nextHandler != null ? nextHandler : new DefaultInvocationProcessHandler();
    }
}
