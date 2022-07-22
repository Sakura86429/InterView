package leetcode;

/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/28 16:20
 */
public class 第53题最大子数组和 {

//    // 每个位置的最大值，都做一次比较
//    public static int maxSubArray2(int[] nums) {
//        int f1 = 0;
//        int f2;
//        int maxAns = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            f1 = Math.max(nums[i], f1 + nums[i]);
//            maxAns = Math.max(maxAns, f1);   // 处理情况：本来是大的，然后--之后变小跳到nums[i]
//        }
////        return f1;
//        return maxAns;
//    }
    public static int maxSubArray(int[] nums) {
        int pre = 0, ans = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);   // 我们需要考虑目前i的pre函数值，是单独nums[i]成为一段还是加上i-1的那一个pre函数值
            ans = Math.max(pre, ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
