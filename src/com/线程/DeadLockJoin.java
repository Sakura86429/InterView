package com.线程;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/22 14:02
 */
public class DeadLockJoin {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        class Do {
            Thread A = null;
            Thread B = null;
            public void doSome() {
                A = new Thread(new Runnable() {   // 正常的将一个实现了Runnable接口的对象放到new Thread中
                    @Override
                    public void run() {
                        System.out.println("A start");
                        try {
                            B.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A end");
                    }
                });
                B = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("B start");
                        try {
                            A.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B end");
                    }
                });
                A.start();
                B.start();
            }
        }
        new Do().doSome();
    }
}
