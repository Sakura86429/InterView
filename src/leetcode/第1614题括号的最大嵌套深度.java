package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/24 13:36
 */
public class 第1614题括号的最大嵌套深度 {
    public static void main(String[] args) {

    }
    public int maxDepth(String s) {
        int ans = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                size++;
                ans = Math.max(ans, size);
            } else if (ch == ')') {
                size--;
            }
        }
        return ans;
    }
}
