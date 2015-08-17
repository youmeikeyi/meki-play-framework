package com.meki.play.framework.design.proxy;

/**
 * Created by xujinchao on 2015/6/30.
 */
public class SimpleProxy implements  Subject {

    private Subject proxied;

    public SimpleProxy(Subject proxied){
        this.proxied = proxied;
    }

    @Override
    public String sayHello(String name, int age) {
        System.out.println("SimpleProxy sayHello...");
        return proxied.sayHello(name, age);
    }

    public static void main(String[] args) {
        String name = "john";
        int age = 22;
        RealSubject realSubject = new RealSubject();
        String messsage = realSubject.sayHello(name, age);
        System.out.println(messsage);
        new SimpleProxy(new RealSubject()).sayHello(name, age);
    }
}
