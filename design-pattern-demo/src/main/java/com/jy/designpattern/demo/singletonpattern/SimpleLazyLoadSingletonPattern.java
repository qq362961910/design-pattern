package com.jy.designpattern.demo.singletonpattern;

/**
 * 懒加载示例
 */
public class SimpleLazyLoadSingletonPattern {

    public static void main(String[] args) {
        System.out.println(LazyLoadSingleton.getInstance());
        System.out.println(LazyLoadSingleton.getInstance());
        System.out.println(LazyLoadSingleton.getInstance());
        System.out.println(LazyLoadSingleton.getInstance());
    }

}

class LazyLoadSingleton {

    //3.定义静态变量缓存单例
    private static LazyLoadSingleton singleton = null;

    //1.私有化构造方法
    private LazyLoadSingleton() {
    }
    //2.定义公开静态方法获取单例(同步)
    public static synchronized LazyLoadSingleton getInstance() {
        //4.如果没有则创建一个,并给敬爱变量赋值
        if (singleton == null) {
            singleton = new LazyLoadSingleton();
        }
        //5.返回使用
        return singleton;
    }
}
