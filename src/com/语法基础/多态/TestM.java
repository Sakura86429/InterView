package com.语法基础.多态;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/9/21 13:55
 */
public class TestM {
    static class A {
        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }

    }

    static class B extends A{
        public String show(B obj){
            return ("B and B");
        }

        public String show(A obj){
            return ("B and A");
        }
    }

    static class C extends B{

    }

    static class D extends B{

    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();   // 当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，
        // 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。
//        B b1 = (B) new A();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
//        String s = "jkljl";
//        s.length();
    }

}
