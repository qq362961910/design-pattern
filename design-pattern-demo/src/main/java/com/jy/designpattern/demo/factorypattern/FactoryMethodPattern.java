package com.jy.designpattern.demo.factorypattern;

import com.jy.designpattern.entity.Animal;
import com.jy.designpattern.entity.Cat;
import com.jy.designpattern.entity.Dog;

/**
 * 工厂方法模式
 *
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new  DogFactory();
        AnimalFactory catFactory = new  CatFactory();
        dogFactory.factory();
        catFactory.factory();
    }

    /**
     * 使用接口或抽象类声明父类工厂
     * 一个工厂接口对应一个产品接口
     * 一个子类工厂实现对应一个子类产品实现
     * */
    interface AnimalFactory {
        Animal factory();
    }

    /**
     * 狗类工厂(具体工厂实现)
     * */
    static class DogFactory implements AnimalFactory {
        public Animal factory() {
            Dog dog = new Dog();
            System.out.println("[DogFactory] 成功创建一个Dog!");
            return dog;
        }
    }

    /**
     * 猫类工厂(具体工厂实现)
     * */
    static class CatFactory implements AnimalFactory {
        public Animal factory() {
            Cat cat = new Cat();
            System.out.println("[CatFactory] 成功创建一个Cat!");
            return cat;
        }
    }


}


