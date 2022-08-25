package com.语法基础;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/25 11:34
 */
public class StaticTest {
    private static int staticInt = 1;//静态变量
    private int random = 1;//实例变量

    public StaticTest() {
        staticInt++;
        random++;
        System.out.println("staticInt = " + staticInt + "  random = " + random);
    }

    public static void main(String[] args) {
        StaticTest test = new StaticTest();
        StaticTest test2 = new StaticTest();

    }
}
