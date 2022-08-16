package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/16 13:22
 */
public class 第42题连续子数组的最大和 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int pre = 0, ans = nums[0];   // 首个ans是nums[0]
        for (int num : nums) {
            pre = Math.max(num, num + pre);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
