package com.jy.designpattern.demo.observerpattern.simple;

/**
 * 客户端
 */
public class Tester {

    private static Watched watched;
    private static Watcher watcher;

    public static void main(String[] args) {
        watched = new Watched();
        watcher = new Watcher(watched);
        for(int i=0; i<10; i++) {
            watched.changeData(i);
        }
    }
}
