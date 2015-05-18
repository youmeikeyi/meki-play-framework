package com.meki.play.framework.design.responsibility;

/**
 * Created by xujinchao on 2015/5/18.
 */
public class Concrete2InvocationProcessHandler extends InvocationProcessHandler {

    @Override
    public boolean canAccept(InvocationRequest request) {
        if (request != null) {
            return true;
        }
        return false;
    }

    @Override
    public InvocationRequest process(InvocationRequest request) {
        request.setName("concrete2 process");
        return request;
    }
}