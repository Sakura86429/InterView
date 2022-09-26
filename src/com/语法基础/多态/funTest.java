package com.语法基础.多态;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/9/26 13:36
 */
public class funTest {
    static class Person{
        public void run() {
            System.out.println("run");
        }
    }
    static class Student extends Person{
        public void run() {
            System.out.println("son run");
        }
        public void eat() {
            System.out.println("eat");
        }
    }

    public static void main(String[] args) {
        Student p1 = new Student();
        Person p2 = new Student();
        Object p3 = new Student();

        p1.run();
        p2.run();

        p1.eat();

    }
}
