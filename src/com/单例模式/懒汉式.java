package com.单例模式;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/16 22:24
 */
public class 懒汉式 {
    public static void main(String[] args) {

    }
}
class Singleton2 {
    private static Singleton2 instance;
    private Singleton2() {}
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
//class Singleton2 {
//    private static Singleton2 singleton;
//    private Singleton2() {}
//    public static Singleton2 getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton2();
//        }
//        return singleton;
//    }
//}
