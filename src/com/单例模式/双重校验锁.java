package com.单例模式;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/16 22:27
 */
public class 双重校验锁 {
    public static void main(String[] args) {
        Singleton.getInstance();   // private只能本类中初始化new 构造
    }
}
class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

//class Singleton {
//    private volatile static Singleton instance;   // volatile防止指令重排
//
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {   //线程1，2同时到达，均通过（instance == null）判断。
//                                  // 线程1进入下面的同步块，线程2被阻塞
//            synchronized (Singleton.class) {
//                if (instance == null) {   //线程1执行发现instance为null,初始化实例后，释放锁。
//                    // 线程2进入同步块，此次instance已经被初始化。无法通过if条件，避免多次重复初始化。
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}
