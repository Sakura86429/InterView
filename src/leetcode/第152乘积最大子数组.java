package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/20 18:04
 */
public class 第152乘积最大子数组 {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {   // f(i)存这一时刻（正）最大和（负）最小
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));   // 如果mn为负，nums[i]也为负，正好mn*nums[i]为此次最大
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));   // 上一时刻最大也有可能*负变为这一时刻最小
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
