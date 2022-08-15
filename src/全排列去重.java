import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/15 10:03
 */
public class 全排列去重 {
    public static void main(String[] args) {
        String str = "ABA";
        char[] arr = str.toCharArray();
        Set<List<Character>> ans = new HashSet<>();
        List<Character> sub = new ArrayList<>();
        for (char ar : arr) {
            sub.add(ar);
        }
        dfs(sub, ans, 0, str.length());
        for (List<Character> a : ans) {
            StringBuffer out = new StringBuffer();
            for (char ch : a) {
                out.append(ch);
            }
            System.out.println(out);
        }

    }

    private static void dfs(List<Character> sub, Set<List<Character>> ans, int index, int length) {
        if (index == length) {
            if (!ans.contains(new ArrayList<>(sub))){
                ans.add(new ArrayList<>(sub));
            }
        }
        for (int i = index; i < length; i++) {
            Collections.swap(sub, index, i);
            dfs(sub, ans, index + 1, length);
            Collections.swap(sub, index, i);
        }

    }
}
