package com.meki.play.framework.design.proxy;

/**
 * Created by user on 2015/4/16.
 */
public class Test {

    public static void main(String[] args){
        MyInvocationHandler handler = new MyInvocationHandler();
        Subject subject = (Subject) handler.bind(new RealSubject());
        String message = subject.sayHello("Loyn", 12);
        System.out.println(message);
    }
}
