package com.语法基础;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/9/6 15:27
 */
public class StringAdd {
    public static void main(String[] args) {
        String[] arr = {"he", "llo", "world"};
        StringBuilder s = new StringBuilder();
        for (String value : arr) {
            s.append(value);
        }
        System.out.println(s);   // 直接打印就可以打印出字符串了，而不是类型
    }
}
