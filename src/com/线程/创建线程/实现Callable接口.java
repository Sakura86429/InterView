package com.线程.创建线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/22 14:43
 */
public class 实现Callable接口 {
    public static void main(String[] args) {
        FutureTask task = new FutureTask(new MyThread());
        new Thread(task).start();
    }
    static class MyThread implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println("ccc");
            return 2;
        }
    }
}
