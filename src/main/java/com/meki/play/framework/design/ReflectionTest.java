/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.meki.play.framework.design;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.util.Assert;

/**
 * Created by xujinchao on 18/5/23.
 */
public class ReflectionTest {

    class Test {
        public int num;

        private int id;
        private String name;

        public Test() {
            System.out.println("Default Constructor");
        }

        public Test(int id, String name) {
            this.id = id;
            this.name = name;
            System.out.println("Params Constructor");
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        private void log(String msg) {
            System.out.println("Msg:" + msg);
        }
    }

    class SubTest extends Test {
        public int subNum;

        private int subId;

        public SubTest() {
            System.out.println("Default Constructor");
        }

        public SubTest(int subId, int subNum) {
            this.subId = subId;
            this.subNum = subNum;
            System.out.println("Params Constructor");
        }

        public int getSubId() {
            return subId;
        }

        public void setSubId(int subId) {
            this.subId = subId;
        }

        public int getSubNum() {
            return subNum;
        }

        public void setSubNum(int subNum) {
            this.subNum = subNum;
        }

        private void log(String mgs) {
            System.out.println("Msg:" + mgs);
        }

    }

    public static void main(String[] args) throws Exception {
        /*String superName = ReflectionTest.class.getSuperclass().getName();

        System.out.println("superName:" + superName);

        Boolean test = true;

        System.out.println(test.getClass());

        Class<?> cls = Boolean.TYPE;

        System.out.println(cls);

        Class<?> clst = SubTest.class;

        Field[] fields = clst.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("~~");
        fields = clst.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        Constructor<?>[] constructors = clst.getConstructors();

        for (Constructor<?> m : constructors) {
            System.out.println(m);

        }
        System.out.println();

        Object object = clst.newInstance();
        System.out.println(object);
        Constructor<?> constructor = clst.getConstructor();
        Object cons1 = constructor.newInstance();
        System.out.println("const1:" + cons1);

        Method method = clst.getDeclaredMethod("log", String.class);
        method.setAccessible(true);
        method.invoke(object, "tet");*/

        String str = new String("Meki");
        Assert.isTrue(str.intern() != str);
        Thread.sleep(1000 * 60 * 60);
    }

}
