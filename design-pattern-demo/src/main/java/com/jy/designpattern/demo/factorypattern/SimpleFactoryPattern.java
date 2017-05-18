package com.jy.designpattern.demo.factorypattern;

import com.jy.designpattern.entity.Animal;

import java.io.InputStream;
import java.util.Properties;

/**
 * 简单工厂模式
 *
 * 静态工厂: 通过静态方法创建对象
 * 万能工厂: 可以包含很多构造对象的静态方法,这些方法可以构造不同的接口，抽象类或者类实例
 * 工厂构建对象范围: 简单工厂什么都能构造，但是对于简单工厂可以创建的范围通常不要太大，建议控制在一个独立的组件或者一个模块级别
 *
 * 命名规则:
 *      类名: XxxFactory
 *      方法名: create + "接口名", get + "接口名" (不建议 new + "接口名", 因为每次不一定需要new 一个新实例出来, 会造成错觉)
 *
 * 简单工厂特点:
        1.帮助封装
        2.接偶
        3.增加客户端复杂度
        4.不方便扩展子工厂
 *
 * 简单工厂本质:
 *      选择实现.简单工厂重点在选择，实现是已经做好了的
 *
 * 简单工厂使用场景:
 *        1.想要完全封装隔离具体实现，让外部只能通过接口来操作封装体，客户端无需关注具体实现
 *        2.想要把对外创建对象的职责集中管理和控制
 * */
public class SimpleFactoryPattern {

    public static void main(String[] args) throws Exception{
        String typeDog = "dog";
        Animal dog = AnimalFactory.createAnimal(typeDog);
        dog.eat("骨头");
        dog.shout();
        System.out.println("name is : " + dog.getName());

        String typeCat = "cat";
        Animal cat = AnimalFactory.createAnimal(typeCat);
        cat.eat("鱼");
        cat.shout();
        System.out.println("name is : " + cat.getName());
    }
}

/**
 * 工厂类
 * */
class AnimalFactory {

    private static Properties properties = new Properties();

    static {
        InputStream is = AnimalFactory.class.getResourceAsStream("SimpleFactoryPattern.properties");
        if (is == null) {
            System.out.println("SimpleFactoryPattern.properties not found!");
        }
        else {
            try {
                properties.load(is);
            } catch (Exception e) {
                System.out.println("load SimpleFactoryPattern.properties error");
                e.printStackTrace();
            }
        }
    }

    public static Animal createAnimal(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String clazz = properties.getProperty(type);
        if (clazz != null) {
            return (Animal) Class.forName(clazz).newInstance();
        }
        return null;
    }

}
