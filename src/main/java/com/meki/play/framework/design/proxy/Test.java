package com.meki.play.framework.design.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/4/16.
 */
public class Test {

    public static void main(String[] args){
        MyInvocationHandler handler = new MyInvocationHandler();
        Subject subject = (Subject) handler.bind(new RealSubject());
        String message = subject.sayHello("Loyn", 12);
        System.out.println(message);

        List<String>[] list;
        List[] a = new List[5];
        list = (List<String>[])a;
        System.out.println(list.getClass().getComponentType());
        list[0] = new ArrayList<String>();
//        list[1] = new ArrayList<Integer>();
        Object[] objects = list;
        objects[1] = new ArrayList<Integer>();

    }
}
