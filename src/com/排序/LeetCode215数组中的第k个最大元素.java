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

    private int quickSort(int[] nums, int l, int r, int index) {   // 如果l=r，只有一个元素的时候，肯定有pivot=nums[j]，肯定返回if中的nums[0]
        int pos = randomPartition(nums, l, r);   // 这里不用加if，这里加了if不满足if的反而写不了判断条件。
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSort(nums, pos + 1, r, index) : quickSort(nums, l, pos - 1, index);   // 也可以层层递归直到返回到值nums[pos]
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;   // 临时变量，名字和上一个函数的i相同，但是不会影响
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
