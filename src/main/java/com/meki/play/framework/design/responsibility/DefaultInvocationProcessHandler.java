package com.meki.play.framework.design.responsibility;

/**
 * Created by xujinchao on 2015/6/3.
 */
public class DefaultInvocationProcessHandler extends InvocationProcessHandler {

    public DefaultInvocationProcessHandler(){
        setNextHandler(null);
    }

//    public DefaultInvocationProcessHandler(InvocationProcessHandler nextHandler) {
//        super.nextHandler = nextHandler;
//    }

    @Override
    public void setNextHandler(InvocationProcessHandler handler) {
        super.setNextHandler(handler);
    }

    @Override
    public boolean canAccept(InvocationRequest request) {
        return true;
    }

    @Override
    public InvocationRequest process(InvocationRequest request) {
        if (canAccept(request)) {
            request.setName("default process : do nothing");
        }
        return request;
    }

    @Override
    public InvocationProcessHandler next() {
        return null;
    }
}
