package com.线程;

/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/26 11:00
 */
public class ThreadJoinYield {
    public volatile static int i = 0;
    public static void main(String[] args) throws Exception{
        Thread thread = new AddThread();
        thread.start();
        Thread thread2 = new Thread2();
        thread2.start();
        //阻塞当前线程，即main线程，直到AddThread线程执行完毕
        thread.join();
        System.out.println(i);

    }

    public static class AddThread extends Thread {
        public void run() {
            System.out.println("AddThread started ...");
            for (i=0;i<1000000;i++) {
                if (i%500000==0) {   // 2次
                    System.out.println("thread yield cpu");
                    //使当前线程让出CPU时间
                    Thread.yield();
//                    System.out.println(System.currentTimeMillis());
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread begin running");
        }
    }
}
