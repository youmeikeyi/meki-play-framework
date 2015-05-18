package com.meki.play.framework.design.responsibility;

/**
 * Created by xujinchao on 2015/5/18.
 */
public class InvocationRequest {

    private String name = "request";

    public InvocationRequest() {}

    public InvocationRequest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
