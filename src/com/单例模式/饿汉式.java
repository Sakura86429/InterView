package com.单例模式;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/16 22:20
 */
public class 饿汉式 {
    public static void main(String[] args) {

    }
}
class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1 () {}   // 可以为四种修饰符之一，但是private表示只能在当前类中访问它，不能被继承【只能本类中使用new构造】
    public static Singleton1 getInstance() {
        return instance;
    }
}
