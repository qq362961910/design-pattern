package com.jy.designpattern.demo.singletonpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 登记式单例模式
 * */
public class SimpleRegSingletonPattern {
    public static void main(String[] args) {
        System.out.println(RegSingleton.getInstance(null));
        System.out.println(RegSingleton.getInstance(null));
        System.out.println(RegSingleton.getInstance(null));
        System.out.println(RegSingleton.getInstance(null));
    }
}
class RegSingleton {

    private static final Object lock = new Object();

    //2.登记簿,用来登记所有的实例
    private static Map<String, RegSingleton> registration = new HashMap<String, RegSingleton>();

    //1.私有化构造方法
    private RegSingleton() {
    }

    //3.提供公共静态方法获取单例
    public static synchronized RegSingleton getInstance(String name) {
        if (name == null) {
            name = "RegSingleton";
            String basePackage = RegSingleton.class.getPackage().getName();
            if (basePackage != null && basePackage.length() > 0) {
                name = basePackage + "." + name;
            }

        }
        RegSingleton singleton = registration.get(name);
        if (singleton == null) {
            synchronized (lock) {
                singleton = registration.get(name);
                if (singleton == null) {
                    try {
                        singleton = (RegSingleton)Class.forName(name).newInstance();
                        registration.put(name, singleton);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return singleton;
    }
}
