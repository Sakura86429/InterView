package leetcode;

/**
 * Topic
 * Description
 * 双向指针
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/19 22:40
 */
public class 第977题有序数组的平方 {
    public static void main(String[] args) {

    }
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {   // 区间r为nums.length-1的时候就为<=
            // l和r一直移动到l和r相等，执行完操作后++或者--正好超出范围
            int lSq = nums[l] * nums[l];
            int rSq = nums[r] * nums[r];
            if (lSq > rSq) {
                res[index--] = lSq;
                l++;   // 和二分法的区间+ - 是一个道理
            } else {
                res[index--] = rSq;
                r--;
            }
        }
        return res;
    }
}
