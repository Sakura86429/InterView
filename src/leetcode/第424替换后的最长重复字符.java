package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/3 9:48
 */
public class 第424替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;   // 左右下标
        int n = s.length();
        int maxn = 0;   // 通过下面的if维持窗口中曾出现某个字母的最大次数，窗口长度只能增大（因为我们要找的是最长，所以不影响）
        int[] nums = new int[26];
        while (right < n) {
            nums[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, nums[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                nums[s.charAt(left) - 'A']--;
                left++;
            }
            right++;   // 走完这里的时候，其实right会多走一步
        }
        return right - left;   // 因为right已经多走一步了，所以不用再+1，结果为(right-1)-left+1==right-left
    }
}
