package com.排序;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/19 11:27
 */
public class 二分法 {

    public static void main(String[] args) {
        int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };
        int[] arr2 = new int[] { 90 };
        System.out.println(search(arr, 12));
        System.out.println(search(arr, 45));
        System.out.println(search(arr, 67));
        System.out.println(search(arr, 89));
        System.out.println(search(arr, 99));
        System.out.println(search(arr2, 91));
    }

//    private static int search(int[] arr, int i) {
//        int l = 0;
//        int r = arr.length - 1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (arr[mid] > i) r = mid - 1;   // 固定target，填位置
//            else if (arr[mid] < i) l = l + 1;
//            else return arr[mid];
//        }
//        return -1;
//    }

//    private static int search(int[] arr, int i) {
//        int start = 0;
//        int end = arr.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (i < arr[mid]) {
//                end = mid - 1;
//            } else if (i > arr[mid]) {
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    private static int search(int[] arr, int i) {   // 左闭右开
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > i) r = mid;
            else if (arr[mid] < i) l = mid + 1;
            else return arr[mid];
        }
        return -1;
    }
}
