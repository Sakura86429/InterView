package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/17 10:47
 */
public class 第17题电话号码的字母组合 {
    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(ans, phoneMap, digits, 0, new StringBuffer());
        return ans;
    }

    private void dfs(List<String> ans, Map<Character, String> phoneMap, String digits, int index, StringBuffer sub) {
        if (index == digits.length()) {   // 添加一个变为1，添加n个变为n
            ans.add(sub.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);   // 例：得到abc
            for (int i = 0; i < letters.length(); i++) {   // 遍历添加a、b、c
                sub.append(letters.charAt(i));
                dfs(ans, phoneMap, digits, index + 1, sub);   // 如果是数字2，就分三个分支回溯
                sub.deleteCharAt(index);   // 删除sub添加的第一个元素（abc中的一个）
            }
        }
    }
}
