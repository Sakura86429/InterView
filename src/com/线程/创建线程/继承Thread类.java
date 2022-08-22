package com.线程.创建线程;

/**
 * Topic
 * Description
 * 创建一个类继承Thread类，重写run()方法，在主线程中创建此类的对象，调用对象的start()方法，可启动线程
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/22 14:39
 */
public class 继承Thread类 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("aaa");
        }
    }
}
