package com.meki.play.framework.design.factory.abs;

import com.meki.play.framework.config.AppConfigs;
import com.meki.play.framework.config.ConfigurationManager;
import com.meki.play.framework.design.bean.User;

import java.lang.reflect.*;
import java.util.Observable;

/**
 * 利用java反射改造抽象工厂模式
 * 可结合配置文件
 * Created by user on 2015/4/14.
 */
public class Test {
//    private static Class<?> cls = null;

    /**
     * 获取当前类的包名+类名
     *
     * @return
     */
    public String getName() {
        return this.getClass().getName();
    }

    public void selfAttribute() {
        Class<?> cls = Test.class;
        System.out.println("===============本类属性========================");
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            // 权限修饰符
            int mo = fields[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = fields[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + fields[i].getName() + ";");
        }

        // 取得实现的接口或者父类的属性
        Field[] filed1 = cls.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + filed1[j].getName() + ";");
        }
    }

    public static void getConstructor(Class<?> cls) {
        Constructor<?>[] con = cls.getConstructors();
        for (int i = 0; i < con.length; i++) {
            //test private constructor not shown
//                System.out.println("1." + con[i]);
            Class<?> p[] = con[i].getParameterTypes();
            int modifier = con[i].getModifiers();
            System.out.print(Modifier.toString(modifier) + " ");
            System.out.print(con[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < p.length; ++j) {
                System.out.print(p[j].getName() + " arg" + i);
                if (j < p.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }

    }

    public static void getMethods(Class<?> cls) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; ++i) {
            Class<?> returnType = methods[i].getReturnType();
            Class<?> param[] = methods[i].getParameterTypes();

            int temp = methods[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(methods[i].getName() + " ");
            System.out.print("(");

            for (int j = 0; j < param.length; ++j) {
                System.out.print("" + param[j].getName() + " arg" + j);
                if (j < param.length - 1) {
                    System.out.print(",");
                }
            }
            //
            Class<?> exce[] = methods[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

    }

    /**
     * 操作数组
     * 修改数组元素  数组大小
     */
    public static void getArrayAttr() {
        int[] temp = {1, 2, 3, 4};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));

        int[] newTemp = (int[]) arrayInc(temp, 10);
        print(newTemp);
        System.out.println("====change size ====");
        String[] strings = {"a", "b", "c"};
        strings = (String[]) arrayInc(strings, 5);
        print(strings);
    }

    /**
     * 修改数组大小
     */
    public static Object arrayInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        //复制
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    /**
     * 打印
     */
    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组最新长度为： " + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
    }



    public static void main(String[] args) {
        Test test = new Test();
        // 1 三种方式
        Class<?> cls = Test.class;
        //2
//        cls = new Test().getClass();
        try {
            //3
            cls = Class.forName("com.meki.play.framework.design.factory.abs.Test");

            //通过Class实例化其他类
            cls = Class.forName("com.meki.play.framework.design.bean.User");

            //joke  操作方法
            Object object = cls.newInstance();
            Method method = cls.getMethod("sayHello");
            method.invoke(object);

            method = cls.getMethod("sayHello", String.class);
            //获取返回值 void返回null
            Object o = method.invoke(object, "uuu");
            System.out.println(o);
            setter(object, "Name", "Fuck", String.class);
            getter(object, "Name");

            System.out.println(object);

            //操作属性 没有get/set方法也可以
            Field field = cls.getDeclaredField("sex");
            field.setAccessible(true);
            field.set(object, "Dog");
            System.out.println(field.get(object));

            getArrayAttr();
            System.out.println();

            String loader = cls.getClassLoader().getClass().getName();
            System.out.println("loader :" + loader);
            //=============================
            System.out.println("Constructor:");
//            getConstructor(cls);
            //=============================
            System.out.println("Methods:");
//            getMethods(cls);
            //==============================
            Class<?>[] inface = cls.getInterfaces();
            System.out.println("================");
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
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(test.getName());


    }

    /**
     * @param obj 操作的对象
     * @param att 操作的属性
     */
    public static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param obj   操作的对象
     * @param att   操作的属性
     * @param value 设置的值
     * @param type  参数的属性
     */
    public static void setter(Object obj, String att, Object value,
                              Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
