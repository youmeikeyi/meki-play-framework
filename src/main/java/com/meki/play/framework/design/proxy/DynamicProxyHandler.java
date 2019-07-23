package com.meki.play.framework.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理角色
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
        System.out.println(real.sayHello("ss", 12));

        InvocationHandler invocationHandler = new DynamicProxyHandler(real);

        System.out.println();
        // Proxy.newProxyInstance构建代理对象
        Subject proxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class}, invocationHandler);

//        Class<?> classType = invocationHandler.getClass();
//        proxy = (Subject) Proxy.newProxyInstance(classType.getClassLoader(),
//                real.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello("ss", 22);
    }
}
