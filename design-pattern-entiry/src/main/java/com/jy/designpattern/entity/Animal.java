package com.jy.designpattern.entity;

/**
 * 动物
 * */
public interface Animal {

    /**
     * 叫
     * */
    void shout();

    /**
     * 吃
     * */
    void eat(String food);

    /**
     * 名字
     * */
    String getName();
}
