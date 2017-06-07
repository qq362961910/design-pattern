package com.jy.designpattern.demo.builderpattern;

/**
 * 汽车组装操作封装类
 */
public class CarDirector {

    public void makeCar() {
        carBuilder.makeHead();
        carBuilder.makeBody();
        carBuilder.makeTail();
    }

    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }
}
