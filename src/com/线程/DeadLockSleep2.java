package com.线程;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/22 14:17
 */
public class DeadLockSleep2 {
//    public static void main(String[] args) {
//        Object A = new Object();
//        Object B = new Object();
//
//        Thread t1 = new Thread(()->{   // ()->{}是lambda表达式的写法
//           synchronized (A) {
//               System.out.println("t1 getLock A");
//               try {   // 注释掉sleep仍然会死锁，目测是因为都start启动了
//                   Thread.sleep(2000);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               synchronized (B) {
//                   System.out.println("t1 getLock B");
//               }
//           }
//            System.out.println("t1 end");
//        });
//
//        Thread t2 = new Thread(()->{
//           synchronized (B) {
//               System.out.println("t2 getLock B");
//               try {
//                   Thread.sleep(2000);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               synchronized (A) {
//                   System.out.println("t2 getLock A");
//               }
//           }
//            System.out.println("t2 end");
//        });
//
//        t1.start();
//        t2.start();
//    }
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(A) {
                    System.out.println("t1 getLock A");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("t1 getLock B");
                    }
                }
                System.out.println("t1 end");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println("t2 getLock B");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A) {
                        System.out.println("t2 getLock A");
                    }
                }
                System.out.println("t2 end");
            }
        });

        t1.start();
        t2.start();
    }
}
