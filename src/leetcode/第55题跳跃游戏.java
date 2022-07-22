package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/25 21:41
 */
public class 第55题跳跃游戏 {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {   // 首元素满足0=0   // 下标i应该满足可以到达
                rightMost = Math.max(rightMost, i + nums[i]);   // rightMost为max（上一次最大，i+nums[i]），即i位置所能跑的最远距离【i+nums[i]即得到i可以向前走到哪】
                if (rightMost >= nums.length - 1) return true;   // rightMost下标>=n - 1的时候即符合条件
            }
        }
        return false;
    }
}
