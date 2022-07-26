package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/1 10:53
 */
class 第8题字符串转换整数 {
    public static void main(String[] args) {

    }
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {
        {
            put("start", new String[] {"start", "signed", "in_number", "end"});   // start遇到谁都是谁
            put("signed", new String[] {"end", "end", "in_number", "end"});   // signed遇到in_number才不是end
            put("in_number", new String[] {"end", "end", "in_number", "end"});
            put("end", new String[] {"end", "end", "end", "end"});
        }
    };

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);   // 截断整数2^31-1，-2^31
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }

    }

    private int get_col(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (Character.isDigit(c)) return 2;
        return 3;
    }
}
