package com.排序;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/23 19:51
 */
public class List和int数组的逆序排序 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        Collections.sort(list);   // 默认从小到大
        System.out.println(list);
        Collections.sort(list, (a, b)->b-a);   // 从大到小
        System.out.println(list);

//        int[] arr = new int[]{2, 3};
        Integer[] arr = new Integer[]{2, 3};
        Arrays.sort(arr);
        Arrays.sort(arr, (a, b)->b-a);
        for (int num : arr) {   // 自动拆箱为int
            System.out.print(num + " ");
        }
    }

}
