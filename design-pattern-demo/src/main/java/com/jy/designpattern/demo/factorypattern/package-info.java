/**
 * 工厂模式
 *
 * 简单工厂与工厂方法模式对比
 *　1.结构复杂度
 *      简单工厂占优势, 简单工厂模式只需要一个工厂类, 工厂方法模式的工厂类随着产品类个数增加而增加,
 *      会使类的个数越来越多, 从而增加了结构的复杂程度
 *  2.代码复杂度
 *      代码复杂度和结构复杂度相矛盾, 简单工厂模式的工厂随着产品类的增加需要增加很多方法,
 *      而工厂方法模式每个具体工厂只完成单一任务，代码简洁
 *  3.客户端编程难度
 *      工厂方法模式虽然在工厂类结构中引入了接口,从而满足了OCP原则,但是在客户端编码中需要对工厂类进行实例化,
 *      而简单工厂类是个静态类, 在客户端无需实例化
 *  4.管理上的难度
 *      工厂方法模式完全满足OCP原则, 即拥有非常好的扩展性.简单工厂同样具备良好的扩展性,
 *      扩展的时候紧需要修改少量代码就可满泽扩展性的要求,　尽管没有完全满足OCP原则，　但不要太拘泥于设计理论
 *
 *  分析得出,简单工厂模式更好用更方便些,工厂方法模式更"先进"一些,但有时过于先进的东西未必合适使用
 *
 *
 * */
package com.jy.designpattern.demo.factorypattern;