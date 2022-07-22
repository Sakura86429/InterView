package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/27 22:44
 */
public class 第409最长回文串 {

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;   // a的话就是count[97]++
        }
        int ans = 0;
        for (int v : count) {   // 一共[0, 127)都遍历了
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {   // 通过ans%2来限制下一个奇数不能通过
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println('a' - 'b');   // -1
        String s = "aassdddc";
        System.out.println(longestPalindrome(s));
    }
}
