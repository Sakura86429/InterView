package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/22 15:11
 */
public class 第415字符串相加 {
    public static void main(String[] args) {

    }
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {   // 最后都加完如果还有进位也会执行add！=0
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';   // 因为有j--所以i最小到-1
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
        }
        ans.reverse();
        return ans.toString();   // 转为String类返回
    }
}
