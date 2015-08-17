package com.meki.play.framework.design.proxy;

import com.meki.play.util.message.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 与动态代理混合
 * Created by user on 2015/4/16.
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                new TwoTuple(new RealSubject(), Subject.class)
        );
        Subject s = (Subject) mixin;
        String result = s.sayHello("sdf", 2);
        System.out.println(result);
    }
}

class MixinProxy implements InvocationHandler{
    Map<String, Object> delegateByMethods;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegateByMethods = new HashMap<String, Object>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.secound.getMethods()) {
                String methodName = method.getName();
                if (!delegateByMethods.containsKey(methodName)) {
                    delegateByMethods.put(methodName, pair.first);
                }
            }
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegateByMethods.get(methodName);
        return method.invoke(delegate, args);
    }

    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].secound;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}
