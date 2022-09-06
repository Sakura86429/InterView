package com.语法基础.代码块执行顺序;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/9/6 15:56
 */
public class Cat extends Animal{
    static{
        System.out.println("子类的静态方法");
    }
    {
        System.out.println("执行子类的构造代码块");
    }
    public Cat(){
        System.out.println("执行子类的构造方法");
    }
    @Override
    public void A() {
        System.out.println("执行子类的A方法");
    }
}

