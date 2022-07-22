package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 12:41
 */
public class 第438找到字符串中所有字母异位词 {
    public static void main(String[] args) {

    }
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {   // 制造pLen长的窗口
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) ans.add(0);   // i=0如果满足加上
        for (int i = 0; i < sLen - pLen; ++i) {   // 例如：4 - 2 = 2，下标就是0，1   // 往后移动i=1的窗口...
            --sCount[s.charAt(i) - 'a'];   // 维护窗口中每种字母的数量 例：i=0
            ++sCount[s.charAt(i + pLen) - 'a'];   // 例：i+2 = 下标2

            if (Arrays.equals(sCount, pCount)) ans.add(i + 1);
        }
        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++count[s.charAt(i) - 'a'];   // s
            --count[p.charAt(i) - 'a'];   // p
        }
        int differ = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) differ++;
        }
        if (differ == 0) ans.add(0);
        for (int i = 0; i < sLen - pLen; i++) {   // 每次移动判断头和尾变化的differ即可
            if (count[s.charAt(i) - 'a'] == 1) --differ;   // 如果0位置 此时 是1，那么窗口右移之后正好变成0，就--differ
            else if (count[s.charAt(i) - 'a'] == 0) ++differ;   // 如果此时为0，（移动后变为1），++differ
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) ans.add(i + 1);
        }
        return ans;
    }
}
