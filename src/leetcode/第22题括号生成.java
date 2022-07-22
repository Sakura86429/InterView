package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/16 9:35
 */
public class 第22题括号生成 {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String cur = "";
        dfs(list, cur, n, n, n);
        return list;
    }

    private void dfs(List<String> list, String cur, int left, int right, int max) {   // 自顶向下分叉递归，刚开始的变量：list等都相当于函数中的全局变量
        if (cur.length() == 2 * max && left == 0 && right == 0) {   // left == 0 && right == 0的时候才会添加到list并return
            list.add(cur);
            return;
        }
        if (left > right) return;   // 当cur的右括号大于左括号就为无效字符串
        if (left > 0) dfs(list, cur + "(", left - 1, right, max);   // left和right不全为0的时候分别添加
        if (right > 0) dfs(list, cur + ")", left, right - 1, max);
    }
}
