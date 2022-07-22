package leetcode;

import java.util.Scanner;

/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/15 9:56
 */
public class 第5题最长回文子串 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";   // 因为s是对象，所以可以是null值
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerExpand(s, i, i);   // 奇数拓展
            int len2 = centerExpand(s, i, i + 1);   // 偶数拓展，当i+1越界之后函数判断自动计算len=0【i从0-n-1】【因为奇数已经计算过了，，所以这里只计算偶数判0】
            int len = Math.max(len1, len2);   // len只是存一个最大值，len - 1才是最长回文子串的长度
            if (len > end - start) {
                start = i - (len - 1) / 2;   // 奇数3 - 1=2，偶数4-1=3，/2之后都得1；正好奇数中间下标-1，偶数firstEnd下标也-1
                end = i + len / 2;   // 奇数中间+3/2=+1；偶数firstEnd+4/2=+2
            }
        }
        return s.substring(start, end + 1);
    }

    private static int centerExpand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;   // 向外拓展
            ++r;
        }
        return r - l - 1;   // 因为临界条件后依然会计算一次left--和right++
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = longestPalindrome(s);
        for (char ch : ans.toCharArray()) {
            System.out.print(ch);
        }
    }

}
