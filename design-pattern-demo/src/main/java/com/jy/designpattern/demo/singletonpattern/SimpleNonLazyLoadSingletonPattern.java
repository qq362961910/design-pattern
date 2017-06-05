package com.jy.designpattern.demo.singletonpattern;

/**
 * 饿汉式加载示例
 */
public class SimpleNonLazyLoadSingletonPattern {

    public static void main(String[] args) {
        System.out.println(SimpleNonLazyLoadSingleton.getInstance());
        System.out.println(SimpleNonLazyLoadSingleton.getInstance());
        System.out.println(SimpleNonLazyLoadSingleton.getInstance());
        System.out.println(SimpleNonLazyLoadSingleton.getInstance());
    }
}

class SimpleNonLazyLoadSingleton {

    //3.定义一个静态变量缓存单例
    private static final SimpleNonLazyLoadSingleton singleton = new SimpleNonLazyLoadSingleton();

    //1.私有化构造方法
    private SimpleNonLazyLoadSingleton() {
    }
    //2.定义一个公开静态方法为客户端提供单例
    public static SimpleNonLazyLoadSingleton getInstance(){
        return singleton;
    }
}
