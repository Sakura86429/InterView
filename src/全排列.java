import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/26 10:51
 */
public class 全排列 {
    public static List<String> fullArr(String s) {
        List<String> list = new ArrayList<>();   // 使用一个list来存储全排列的结果
        list.add("" + s.charAt(0));   // 初始化list数组，添加字符串的第一个元素 例：A
        for (int i = 1; i < s.length(); i++) {
            List<String> new_list = new ArrayList<>();   // 创建临时数组存储本次for循环生成的结果
            char ch = s.charAt(i);
            for (String str : list) {   // 遍历当前list
                new_list.add(str + ch);   // 新字符插入到字符串的右面，并加入new_list 例：AB
                new_list.add(ch + str);   // 新字符插入到字符串的左面，并加入new_list 例：BA
                for (int j = 1; j < str.length(); j++) {   // 新字符插入到字符串的中间（当list中只有一个元素的时候length=1，for循环不满足<条件不会执行）
                    String str2 = str.substring(0, j) + ch + str.substring(j);   // length=2的时候正好 左+ch+右
                    new_list.add(str2);   // 新字符插入中间，并加入new_list
                }
            }
            list = new_list;   // 同步new_list给list，继续下一步的for循环
        }
        // 去重，建议用set
        List<String> ans = new ArrayList<>();
        for (String str : list) {
            if (!ans.contains(str)) {   // contains是On查找，其中n为str.length()
                ans.add(str);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        String s = "ABCA";
        String s = "ABA";
        for (String str : fullArr(s)) {
            System.out.println(str);
        }
//        List<List<Character>> output = fullArr2(s);
//        for (List<Character> list : output) {
//            for (char ch : list) System.out.print(ch);
//            System.out.println();
//        }
    }
    public static List<List<Character>> fullArr2(String s) {
        char[] arrs = s.toCharArray();
        int n = s.length();
        List<List<Character>> ans = new ArrayList<>();
        List<Character> sub = new ArrayList<>();
        for (char ch : arrs) {
            sub.add(ch);
        }
        dfs(ans, sub, n, 0);
        return ans;
    }

    private static void dfs(List<List<Character>> ans, List<Character> sub, int n, int index) {
        if (sub.size() == n) {
            ans.add(new ArrayList<>(sub));
        }
        for (int i = index; i < n; i++) {
            Collections.swap(sub, index, i);
            dfs(ans, sub, n, index + 1);
            Collections.swap(sub, index, i);
        }
    }
}
