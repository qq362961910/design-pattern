package com.jy.designpattern.demo.singletonpattern;

/**
 * 最好的单例模式,既有饿汉式的效率又有懒加载特性
 */
public class SimpleBestSingletonPattern {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}

class Singleton {

    //1.私有化构造方法
    private Singleton() {
        System.out.println("create");
    }
    //2.创建一个私有静态内部类, 在未调用getInstance之前是不会加载到该类
    private static class SingletonHolder {
        //3.私有静态内部类缓存单例
        private static Singleton singleton = new Singleton();
    }
    //3.公开单例静态方法
    public static Singleton getInstance() {
        //4.加载SingletonHolder类,并实例化单例,不需要加锁
        return SingletonHolder.singleton;
    }
}
