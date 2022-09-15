package leetcode;

import java.util.Random;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/20 16:02
 */
public class 第912题排序数组 {
    public static void main(String[] args) {
        第912题排序数组 A = new 第912题排序数组();

    }
//    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void quickSort(int[] nums, int l, int r) {
//        if (l < r) {
//            int pos = randomPartition(nums, l, r);
//            quickSort(nums, l, pos - 1);   // 此时下标pos已经找到了它应在的位置
//            quickSort(nums, pos + 1, r);
//        }
//    }
//
//    private int randomPartition(int[] nums, int l, int r) {   // r - l即是l走几步到r，因为nextInt取到0 - n-1，所以要加1
//        int i = new Random().nextInt(r - l + 1) + l;   // 随机选取一个主元i   // Random().nextInt（n）可以取0到n-1
//        swap(nums, r, i);   // 把主元放到最右边r下标
//        return partition(nums, l, r);
//    }
//
//    private int partition(int[] nums, int l, int r) {   // 此时r是我们在randomPartition随机选取的主元i
//        int pivot = nums[r];
//        int i = l - 1;
//        for (int j = l; j <= r - 1; j++) {
//            if (nums[j] <= pivot) {
//                i = i + 1;   // i+1第一个是最左l处
//                swap(nums, i, j);   // 反正有小的逐渐往左放就行了，j会往右移动的
//            }
//        }
//        swap(nums, i + 1, r);   // 最后交换主元下标和i再 + 1后的下标。这是下标i+1左边全更小，右边全更大
//        return i + 1;   // 返回i再+1后的主元元素位置
//    }
//
//    private void swap(int[] nums, int r, int i) {
//        int temp = nums[r];
//        nums[r] = nums[i];
//        nums[i] = temp;
//    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomPartition(nums, l, r);
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    private static int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partion(nums, l, r);
    }

    private static int partion(int[] nums, int l, int r) {
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
