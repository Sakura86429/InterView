package com.线程.创建线程;

/**
 * Topic
 * Description 实现Runnable接口的对象要放到new Thread中
 * 需要先将实现Runnable接口的类的对象，当做参数传给new Thread，这样就实现了线程的启动
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/22 14:41
 */
public class 实现Runnable接口 {
    public static void main(String[] args) {
        Thread mt = new Thread(new MyThread());
        mt.start();
    }
    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("bbb");
        }
    }
}
