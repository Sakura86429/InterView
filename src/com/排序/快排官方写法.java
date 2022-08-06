package com.排序;

import java.util.Random;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/6 15:54
 */
public class 快排官方写法 {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 3, 1};
        int[] ans = sortArray(arr);
        for (int n : ans) System.out.print(n + ",");
    }
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {   // 如果初始l=r，说明只有一个元素；如果递归过程l=r说明分到了1个元素的数组排序，不排序1个元素
            int pos = randomPartition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    private static int randomPartition(int[] nums, int l, int r) {
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(nums, pos, r);
        return partition(nums, l, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;   // i永远指向<pivot的最后一个元素下标
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int pos, int r) {   // 形参起名无所谓
        int temp = nums[pos];
        nums[pos] = nums[r];
        nums[r] = temp;
    }

}
