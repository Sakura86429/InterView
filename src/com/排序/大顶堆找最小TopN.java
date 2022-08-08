package com.排序;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/20 17:23
 */
public class 大顶堆找最小TopN {
    static int N = 4;
    static PriorityQueue<Integer> queue;   // 优先级队列默认小顶堆
    public static void main(String[] args) {
        queue = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;   // 第二个元素大于第一个元素，由大到小排序   （o2-o1，o1在后面就是从大到小；o1-o2，o2在后面就是从小到大，默认从小到大）// 大的在后面
            }
        });
//        int[] arr = {1, 3, 5, 2, 6};
        int[] arr = {1, 3, 5, 2};
//        int[] arr = {1,2,3,4,5,6,7,8};
        for (int num : arr) {   // 把数组元素放到堆中
            大顶堆找最小TopN.add(num);
        }
    }

    private static void add(int val) {   // 选出前N大的数
        if (queue.size() < N) {   // 先比较，再添加（size=3，添加元素2，之后此if走完size就会变为4）
            queue.offer(val);
        } else if (queue.size() >= N && val < queue.peek()) {   // 大顶堆堆顶存放堆中最大的数，如果有val比堆顶元素小，就弹出最大（堆顶） 并 添加新元素
            queue.poll();
            queue.offer(val);
        }
        System.out.println("数组中第" + N + "小的数是：" + queue.peek());
        System.out.println("从大到小前N个数的堆为：" + queue);
    }
}
