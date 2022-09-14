package com.排序;

import java.util.Random;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/19 12:47
 */
//    private void  quickSort(int[] arr, int l, int r) {
//        int left = l;
//        int right = r;
//        if (l < r) {
//            int tem = arr[l];
//            while (l < r) {
//                while (l < r && arr[r] > tem) {
//                    --r;
//                }
//                if (l < r) arr[l++] = arr[r];
//                while (l < r && arr[l] < tem) {
//                    l++;
//                }
//                if (l < r) arr[r--] = arr[l];
//            }
//            arr[l] = tem;
//            for (int i : arr) System.out.print(i + " ");
//            System.out.println();
//            quickSort(arr, left, l);
//            quickSort(arr, l + 1, right);
//        }
//    }
public class 快排 {
    public static void main(String[] args) {
        快排 main = new 快排();
//        int[] arrays = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] arrays = { 8, 8, 7, 6, 5, 4, 3, 2, 1 };
        main.quickSort(arrays, 0, arrays.length - 1);
        for (int n : arrays) System.out.print(n + " ");
        System.out.println("Over!");
    }

//    private void quickSort(int[] arr, int l, int r) {
//        int left = l;   // 保存边界值方便在递归的时候使用（因为后面l、r值变化了）
//        int right = r;
//        if (l < r) {
//            int tem = arr[l];   // 选择基准元素为 tem=arr[l]
//            while (l < r) {   // 截止条件 l=r
//                while (l < r && arr[r] > tem) {   //不稳定排序，=可能移动到前面（使用<>不用=）
//                    --r;
//                }
//                if (l < r) arr[l++] = arr[r];
//                while (l < r && arr[l] < tem) {
//                    ++l;
//                }
//                if (l < r) arr[r--] = arr[l];
//            }
//            arr[l] = tem;   // 找到移动到的位置 l=r
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i]);
//            }
//            System.out.println();
//            quickSort(arr, left, l);
//            quickSort(arr, l + 1, right);
//        }
//    }

//    private void quickSort(int[] arr, int l, int r) {
//        if (l < r) {
//            int pos = randomPartition(arr, l, r);
//            quickSort(arr, l, pos - 1);
//            quickSort(arr, pos + 1, r);
//        }
//    }
//
//    private int randomPartition(int[] arr, int l, int r) {
//        int i = new Random().nextInt(r - l + 1) + l;
//        swap(arr, r, i);
//        return partition(arr, l, r);
//    }
//
//    private int partition(int[] arr, int l, int r) {
//        int pivot = arr[r];
//        int i = l - 1;
//        for (int j = l; j <= r - 1; j++) {   // 最右边是r为支点元素
//            if (arr[j] <= pivot) {
//                i = i + 1;
//                swap(arr, i, j);
//            }
//        }
//        swap(arr, i + 1, r);
//        return i + 1;
//    }
//
//    private void swap(int[] arr, int r, int i) {
//        int tem = arr[r];
//        arr[r] = arr[i];
//        arr[i] = tem;
//    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {   // 如果初始l=r，说明只有一个元素；如果递归过程l=r说明分到了1个元素的数组排序，不排序1个元素
            int pos = randomPartition(nums, l, r);
            quickSort(nums, l, pos - 1);   // 没有if判断的话，单个元素l, pos-1这儿就是0，-1会有越界报错
            quickSort(nums, pos + 1, r);
        }
    }

    private static int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] < pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int r) {
        int tem = nums[i];
        nums[i] = nums[r];
        nums[r] = tem;
    }
}
