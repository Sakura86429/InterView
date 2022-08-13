package com.线程池;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/10 16:32
 */
public class ThreadPoolTest {
//    public static void main(String[] args) {
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 8,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(2));
//        int a = 7;
//        for (int i = 1; i <= a; i++) {
//            int j = i;
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    Thread thread = Thread.currentThread();
//                    String name = thread.getName();
//                    int activeCount = pool.getActiveCount();
//                    System.out.println("任务："+j+"-----,线程名称:"+name+"-----活跃线程数:"+activeCount);
////                    thread.sleep(10);
//                }
//            });
//        }
//        pool.shutdown();
//    }

    public static void main(String[] args) {
        // 创建线程池 ， 参数含义 ：（核心线程数，最大线程数，加开线程的存活时间，时间单位，任务队列长度）
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2));

        //设置a的值范围在：a = （corePoolSize-1） ～ (max+queue+1) ,分析：任务数 与 活跃线程数,核心线程数,队列长度,最大线程数的关系。
        int a = 10;

        for (int i = 1; i <= a; i++) {
            int j = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    //获取线程名称
                    Thread thread = Thread.currentThread();
                    String name = thread.getName();
                    //输出
                    int activeCount = pool.getActiveCount();
                    System.out.println("任务："+j+"-----,线程名称:"+name+"-----活跃线程数:"+activeCount);
                }
            });
        }
        //关闭线程池
        pool.shutdown();
    }

}
