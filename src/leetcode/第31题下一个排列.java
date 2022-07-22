package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/24 21:06
 */
public class 第31题下一个排列 {
    public static void main(String[] args) {

    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;   // 找到为【较小数】的i，一定要>=不能>，因为要找到较小数nums[i] < nums[i+1]
        if (i >= 0) {   // 如果已经是最大的了，i=-1，此时不满足这个；将会执行最后的reverse
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;   // 找到为【较大数】的j，一定要有=，因为较大的数一定满足nums[j] > nums[i]
            swap(nums, i, j);   // 交换
        }
        reverse(nums, i + 1);   // 反转较小数的后面
    }


    private void reverse(int[] nums, int startIndex) {
        int left = startIndex, right = nums.length - 1;   // 从两头开始交换（偶数正好满足，奇数中间的那个不用交换）
        while (left < right) {
            swap(nums, left, right);
            left ++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
