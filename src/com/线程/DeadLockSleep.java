package com.线程;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/22 14:09
 */
public class DeadLockSleep {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("thread1 is running");
            synchronized (DeadLockSleep.class) {
                System.out.println("thread is block obj1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Object.class) {
                    System.out.println("thread is block obj2");
                }
            }
        }).start();
        new Thread(()->{
            System.out.println("thread2 is running");
            synchronized (Object.class) {
                System.out.println("thread is block obj2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLockSleep.class) {
                    System.out.println("thread is block obj1");
                }
            }
        }).start();
    }
}
