package com.线程;

/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/26 11:06
 */
public class ThreadWaitNotify {

    private static Object obj = new Object();

    public static void main(String[] args){
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }

    public static class T2 extends Thread {

        public void run() {
            synchronized (obj) {
                System.out.println("T2 start " + System.currentTimeMillis());
                obj.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end " + System.currentTimeMillis());
            }
        }
    }


    public static class T1 extends Thread {

        public void run() {
            synchronized (obj) {
                System.out.println("T1 start " + System.currentTimeMillis());
                try {
                    System.out.println("T1 wait for Object");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end " + System.currentTimeMillis());
            }
        }
    }

}
