package com.meki.play.framework.design.responsibility;

/**
 * Created by xujinchao on 2015/5/18.
 */
public class ConcreteInvocationProcessHandler extends InvocationProcessHandler {

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
            return request;
        }
        return null;
    }
}