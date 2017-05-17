package com.jy.designpattern.entity;

/**
 * 动物抽象类
 * */
public abstract class AbstractAnimal implements Animal{

    private final String name = this.getClass().getSimpleName();


    public void eat(String food) {
        System.out.println(name + " eat: " + food);
    }


    public String getName() {
        return this.name;
    }

}
