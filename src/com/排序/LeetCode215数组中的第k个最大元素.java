package com.排序;

import java.util.Random;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/6 19:37
 */
public class LeetCode215数组中的第k个最大元素 {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1,5,6,4};
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int l, int r, int index) {
        int pos = randomPartition(nums, l, r);
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSort(nums, pos + 1, r, index) : quickSort(nums, l, pos - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int l, int r) {
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }
}
