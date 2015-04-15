package com.meki.play.framework.design.factory.abs;

import com.meki.play.framework.config.AppConfigs;
import com.meki.play.framework.config.ConfigurationManager;
import com.meki.play.framework.design.bean.User;

/**
 * 利用java反射改造抽象工厂模式
 * 可结合配置文件
 * Created by user on 2015/4/14.
 */
public class Test {
//    private static Class<?> cls = null;

    /**
     * 获取当前类的包名+类名
     * @return
     */
    public String getName(){
        return this.getClass().getName();
    }

    public static void main(String[] args){
        Test test = new Test();
        // 1 三种方式
        Class<?> cls = Test.class;
//        cls = new Test().getClass();  //2
        try {
            //3
            cls = Class.forName("com.meki.play.framework.design.factory.abs.Test");

            //通过Class实例化其他类
            cls = Class.forName("com.meki.play.framework.design.bean.User");

            User user;
            user = (User) cls.newInstance();
            user.setId(1);
            user.setName("1");
            System.out.println(user);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(test.getName());


    }
}
