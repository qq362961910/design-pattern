package com.jy.designpattern.demo.builderpattern;

import com.jy.designpattern.entity.Car;

public class Client {
    public static void main(String[] args) {

        //构建吉普车生成器
        CarBuilder carBuilder = new JeepBuilder();
        //CarDirector
        CarDirector carDirector = new CarDirector(carBuilder);
        //组装汽车
        carDirector.makeCar();
        Car car = carBuilder.getCar();
        System.out.println(car);
    }
}
