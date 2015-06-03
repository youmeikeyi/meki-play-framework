package com.meki.play.framework.design.responsibility;

/**
 * 没有设置下一个处理器，下一个就是Default
 * Created by xujinchao on 2015/5/18.
 */
public class ConcreteInvocationProcessHandler extends InvocationProcessHandler {

    public ConcreteInvocationProcessHandler() {
        setNextHandler(nextHandler);
    }

    public ConcreteInvocationProcessHandler(InvocationProcessHandler nextHandler) {
        super.nextHandler = nextHandler;
    }

    @Override
    public boolean canAccept(InvocationRequest request) {
        if (request != null) {
            return true;
        }
        return false;
    }

    @Override
    public InvocationRequest process(InvocationRequest request) {
        if (canAccept(request)) {
            request.setName("concrete process");
        }
        return request;
    }
}