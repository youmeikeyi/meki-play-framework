package com.meki.play.framework.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by xujinchao on 2015/6/30.
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("# proxy : " + proxy.getClass() + ", method:" + method + ", args:" + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }

    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        real.sayHello("ss", 12);

        Subject proxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class}, new DynamicProxyHandler(real));
        proxy.sayHello("ss", 22);
    }
}
