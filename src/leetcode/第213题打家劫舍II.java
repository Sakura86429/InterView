package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/17 17:04
 */
public class 第213题打家劫舍II {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
