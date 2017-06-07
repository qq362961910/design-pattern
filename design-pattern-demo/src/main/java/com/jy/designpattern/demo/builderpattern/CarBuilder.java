package com.jy.designpattern.demo.builderpattern;

import com.jy.designpattern.entity.Car;

/**
 * 汽车组装抽象类
 */
public abstract class CarBuilder {

    /**
     * 组装车头
     * */
    public abstract void makeHead();
    /**
     *　组装车身
     * */
    public abstract void makeBody();
    /**
     *　组装车尾
     * */
    public abstract void makeTail();
    /**
     *　得到组装好的车
     * */
    public abstract Car getCar();
}
