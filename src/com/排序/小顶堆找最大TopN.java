package com.排序;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/20 17:05
 */
public class 小顶堆找最大TopN {
//    static int N = 4;
//    static PriorityQueue<Integer> queue;   // 优先级队列默认小顶堆
//    public static void main(String[] args) {
////        queue = new PriorityQueue<Integer>(N);   // 默认从小到大
//        queue = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;   // 第二个元素大于第一个元素，由小到大排序
//            }
//        });
//        int[] arr = {1, 3, 5, 2, 6};
////        int[] arr = {1, 3, 5, 2};
//        for (int num : arr) {   // 把数组元素放到堆中
//            小顶堆找最大TopN.add(num);
//        }
//    }
//
//    private static void add(int val) {   // 选出前N大的数
//        if (queue.size() < N) {   // 先比较，再添加（size=3，添加元素2，之后此if走完size就会变为4）
//            queue.offer(val);
//        } else if (queue.size() >= N && queue.peek() < val) {   // 小顶堆堆顶存放堆中最小的数，如果有val比堆顶元素大，就弹出最小（堆顶） 并 添加新元素
//            queue.poll();
//            queue.offer(val);
//        }
//        System.out.println("数组中第" + N + "大的数是：" + queue.peek());
//        System.out.println("从小到大前N个数的堆为：" + queue);
//    }
    static PriorityQueue<Integer> queue;
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 6};
        int N = 3;
        queue = new PriorityQueue<>(new Comparator<Integer>() {   // 默认
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int num : arr) {
            小顶堆找最大TopN.add(num, N);
        }
        System.out.println(queue);
    }
    public static void add(int num, int N) {
        if (queue.size() < N) {
            queue.offer(num);
        } else if (queue.size() == N && queue.peek() < num){
            queue.poll();
            queue.offer(num);
        }
    }
}
