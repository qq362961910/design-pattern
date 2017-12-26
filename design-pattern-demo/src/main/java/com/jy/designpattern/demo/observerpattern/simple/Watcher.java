package com.jy.designpattern.demo.observerpattern.simple;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class Watcher implements Observer {

    public void update(Observable o, Object arg) {
        System.out.println(String.format("Data has been changed to: %s", ((Watched)o).retriveData()));
    }

    public Watcher(Watched watched) {
        watched.addObserver(this);
    }
}
