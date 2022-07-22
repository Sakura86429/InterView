package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 13:31
 */
public class 第494目标和 {
    public static void main(String[] args) {

    }
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) count++;
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
