package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/21 10:20
 */
public class 第20题有效的括号 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;   // 剪枝，减少无用循环
        Map<Character, Character> map = new HashMap<Character, Character>() {   // <>里面不写类型会报错
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();   // 双端队列实现堆【双端队列的peek和pop都是顶上那个、入队First那个】（先进后出，堆东西【刚开始的都被堆到下面了】）
        for (int i = 0; i < n; i++) {   // 碰到{[]}的情况时，第一步[已经加进去了，后面直接判断stack堆顶是否存在（或堆是否为空就行了）
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) return false;   // 如果不是相同的类型，或者栈中并没有左括号，那么字符串 s 无效
//                if (stack.peek() != map.get(ch)) return false;   // 【不判stack堆为空，只判断堆顶也可以】
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
