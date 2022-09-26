package com.继承.super和this;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/10 13:37
 */
public class superUse {
    String name = "父类";   // java中字符串可以直接双引号创建
}
class Son extends superUse {
    String name = "子类";
    public void getName() {   // 子类调用父类的变量【此处getName相当于重写了父类的变量？】
        System.out.println(super.name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.getName();
    }
}
