package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/19 22:49
 */
public class 第209题长度最小的子数组 {
    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];   // 只有+-操作，数组出现负数也没关系
            while (sum >= target) {   // 使用while，每次更新起始位置i
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];   // 只有一个元素的话，l++右边也会跟着动r从0开始r++   // 最大到不满足sum>=target，最接近情况也会到l=r+1的位置，之后r进入for循环+1 正常了
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
