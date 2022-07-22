package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/25 9:36
 */
public class 第3题无重复字符的最长子串 {
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();   // 哈希集合，记录每个字符是否出现过
        int n = s.length();
        int r = -1, ans = 0;   // 右指针，初始值为 -1，for循环首先执行while从r+1开始添加
        for (int i = 0; i < n; i++) {
            if (i != 0) {   // 左指针先remove，再不断移动右指针
                set.remove(s.charAt(i - 1));
            }
            while (r < n && r + 1 < n && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));   // 先r+1，再++（如果r+1满足，就让r变为r+1）
                ++r;
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int r = 0, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {   // 滑动窗口
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans, r - i);
        }
        return ans;
    }
}
