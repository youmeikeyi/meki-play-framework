package com.meki.play.framework.design.factory.abs;

import com.meki.play.framework.config.AppConfigs;
import com.meki.play.framework.config.loader.ClassesPropertiesLoader;
import com.meki.play.framework.design.bean.User;
import com.meki.play.framework.design.factory.method.CommonUser;
import com.meki.play.framework.design.factory.method.IUser;
import com.meki.play.framework.design.factory.method.SystemUser;

/**
 * 利用简单工厂改造抽象工厂，可省去抽象工厂接口和具体工厂实现  通过productName区分产品
 * 抽象工厂的缺点：每次增加新的产品，需要新建工厂、create方法等，不符合开闭原则
 *
 * Created by user on 2015/4/15.
 */
public class NewFactory {

    private static String defaultProductName = "user";
//    private static String defaultProductName = "department";

    public NewFactory(){
    }

    public NewFactory(String name){
        defaultProductName = name;
    }

    public AbstractProductA createProductA(String productName) {
        if (productName == null) {
            productName = defaultProductName;
            return new ProductA();
        } else if (productName.equals("department")) {
            return new ProductA2();
        }
        return null;
    }

    public AbstractProductB createProductB(String productName) {
        return new ProductB2();
    }

    //createProductC...
    public IUser createUser(String type) {
        IUser iu = null;
        //TODO 这种if判断可通过反射+配置文件的方式干掉
        if (type.equals("common")) {
            iu = new CommonUser();
        } else if (type.equals("system")) {
            iu = new SystemUser();
        }
        return iu;
    }

    public static void main(String[] args){
        try{

            IUser iu = (IUser) Class.forName("com.meki.play.framework.design.factory.method.CommonUser").newInstance();

            System.out.println(iu.getClass());

            String userStr = AppConfigs.getInstance().get("User");
            iu = (IUser) Class.forName(userStr).newInstance();
            System.out.println(iu.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
