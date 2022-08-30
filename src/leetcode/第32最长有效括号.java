package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/29 17:08
 */
public class 第32最长有效括号 {
    public static void main(String[] args) {

    }
    public int longestValidParentheses(String s) {
        int l = 0, r = 0;
        int res = 0;   // ""的时候为0
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') l++;
            else r++;
            if (l == r) res = Math.max(res, 2 * l);
            else if (r > l) l = r = 0;
        }
//        l = r = s.length() - 1;   // 错误点（1）
        l = r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') r++;
            else l++;
            if (l == r) res = Math.max(res, 2 * r);
            else if (l > r) l = r = 0;
        }
        return res;
    }
//    public int longestValidParentheses(String s) {
//        int l = 0, r = 0, res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') l++;   // 先记录数量
//            else r++;
//            if (l == r) res = Math.max(res, 2 * l);
//            else if (r > l) l = r = 0;
//        }
//         l = r = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == ')') r++;
//            else l++;
//            if (l == r) res = Math.max(res, 2 * r);
//            else if (l > r) l = r = 0;
//        }
//        return res;
//    }
}
//    public int longestValidParentheses(String s) {
//        int left = 0, right = 0, maxLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') left++;
//            else right++;
//            if (left == right) maxLength = Math.max(maxLength, 2 * right);
//            else if (right > left) left = right = 0;
//        }
//        left = right = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == '(') left++;
//            else right++;
//            if (left == right) maxLength = Math.max(maxLength, 2 * left);
//            else if (left > right) left = right = 0;
//        }
//        return maxLength;
//    }
//}
