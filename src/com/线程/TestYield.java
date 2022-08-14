package com.线程;

/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/26 11:23
 */
public class TestYield {

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
//                Thread.yield();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("执行用时：" + (endTime - beginTime));
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread1();
        thread.start();
    }
}
