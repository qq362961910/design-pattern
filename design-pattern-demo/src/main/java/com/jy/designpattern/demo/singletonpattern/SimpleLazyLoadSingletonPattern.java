package com.jy.designpattern.demo.singletonpattern;

import java.util.concurrent.CountDownLatch;

/**
 * 懒加载示例
 */
public class SimpleLazyLoadSingletonPattern {

    public static void main(String[] args) {

        //test1
//        System.out.println(LazyLoadSingleton.getInstance());
//        System.out.println(LazyLoadSingleton.getInstance());

        int threadCount = 50;
        RecorderHolder recorderHolder = new RecorderHolder();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //test2 optimized
        for (int i=0; i<threadCount; i++) {
            new Thread(new Increaser("thread_" + i, countDownLatch, recorderHolder)).start();
        }
        while (countDownLatch.getCount() != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("index: " + recorderHolder.recorder.index);

    }

}



/**
 * 一般懒加载
 * */
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


/**
 * 优化懒加载
 * */
class OptimizedLazyLoadSingleton {

    //3.定义静态变量缓存单例
    private static OptimizedLazyLoadSingleton singleton = null;

    //1.私有化构造方法
    private OptimizedLazyLoadSingleton() {
    }
    //2.定义公开静态方法获取单例(同步)
    public static synchronized OptimizedLazyLoadSingleton getInstance() {
        //4.双重检查加锁, 只在为空时代码同步阻塞
        if (singleton == null) {
            synchronized (OptimizedLazyLoadSingleton.class) {
                if (singleton == null) {
                    singleton = new OptimizedLazyLoadSingleton();
                }
            }
        }
        //5.返回使用
        return singleton;
    }
}


/**
 * 测试懒加载不添加volatile修饰是否有问题
 * */

class Increaser implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private RecorderHolder recorderHolder;
    public void run() {
        System.out.println("thread: " + name + " begin....");
        for (int i=0; i<10000000; i++) {
            increase();
        }
        countDownLatch.countDown();
    }

    public Increaser(String name, CountDownLatch countDownLatch, RecorderHolder recorderHolder) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.recorderHolder = recorderHolder;
    }

    public void increase() {
        synchronized (Recorder.class) {
            recorderHolder.recorder.index++;
        }
    }
}

class RecorderHolder {
    public Recorder recorder = new Recorder();
}

class Recorder {
    public int index = 0;
}


