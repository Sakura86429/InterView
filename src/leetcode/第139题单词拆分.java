package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/13 11:22
 */
public class 第139题单词拆分 {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {   // 填充dp[i]，从第一个开始dp[1]
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {   // 下标j 到 i-1
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];   // dp[s.length()]为最后一个
    }
}
