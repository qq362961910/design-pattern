package com.jy.designpattern.demo.builderpattern;

import com.jy.designpattern.entity.Car;

/**
 * 吉普装配类
 */
public class JeepBuilder extends CarBuilder {

    private Car car = new Car();

    public void makeHead() {
        car.setHead("Jeep Head");
    }

    public void makeBody() {
        car.setBody("Jeep Body");
    }

    public void makeTail() {
        car.setTail("Jeep Tail");
    }

    public Car getCar() {
        return car;
    }
}
