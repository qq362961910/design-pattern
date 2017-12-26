package com.jy.designpattern.demo.observerpattern.simple;

import java.util.Observable;

/**
 * 被观察者
 */
public class Watched extends Observable {

    private Object data;

    public Object retriveData() {
        return data;
    }

    public void changeData(Object data) {
        if(this.data == null) {
            if(data != null) {
                this.data = data;
                setChanged();
            }
        } else {
            if(!this.data.equals(data)) {
                this.data = data;
                setChanged();
            }
        }
        notifyObservers();
    }

}
