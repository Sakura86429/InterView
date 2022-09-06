package com.语法基础.代码块执行顺序;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/9/6 15:54
 */
public class Animal {
    static{
        System.out.println("父类的静态方法");
    }
    {
        System.out.println("执行父类的构造代码块");
    }
    public Animal(){
        System.out.println("执行父类的构造方法");
    }
    public void A(){
        System.out.println("执行父类的A方法");
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        c.A();
    }

}
