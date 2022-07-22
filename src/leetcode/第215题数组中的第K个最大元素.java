package leetcode;

import com.sun.javaws.security.AppPolicy;

import java.util.Random;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/5 10:11
 */
public class 第215题数组中的第K个最大元素 {
//    Random rand = new Random();
//    public int findKthLargest1(int[] nums, int k) {
//        return quickSort1(nums, k, 0, nums.length - 1);
//    }
//
//    private int quickSort1(int[] nums, int k, int left, int right) {   // nums[i]修改下标i处的元素值
//        int index = rand.nextInt(right - left  +1) + left;   // random取一个基准元素，取个数移动left（+left）
//        int temp = nums[index];   // 将基准元素值存起来
//        nums[index] = nums[left];   // 随机基准的话，因为首先交换要覆盖nums[l]，所以要把left存给nums[index]
//        int l = left, r = right;   // 将left和right保存一份用于移动位置，原始的left和right用于最后的quickSort1递归
//        while (l < r) {
//            while (l < r && nums[r] <= temp) r--;   // 小的在右边
//            nums[l] = nums[r];
//            while (l < r && nums[l] >= temp) l++;   // 大的在左边，方便左边下标第一个是第1大的元素
//            nums[r] = nums[l];
//        }
//        nums[l] = temp;
//        if (l == k - 1) return nums[l];
//        else if (l < k - 1) return quickSort1(nums, k, l + 1, right);
//        else return quickSort1(nums, k, left, l - 1);
//    }

    public static void main(String[] args) {

    }

    // leetcode官方解法
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);   // 第1大下标元素位于n-1下标处
    }

    private int quickSort(int[] nums, int l, int r, int index) {
        int pos = randomPartition(nums, l, r);
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSort(nums, pos + 1, r, index) : quickSort(nums, l, pos - 1, index);   // 固定index位置，如果pos小，就往右边找
            // 如果pos位置大，就往左边找
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;   // 2-0=2，再-1=1，符合随机出0，1 + l（0）下标
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];   // 主元的值   // 也是哨兵元素
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {   // 小的移动左边，大的不动   // 如果都不动说明pivot最小在i+1=l下标处
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int r) {
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
    }
}
