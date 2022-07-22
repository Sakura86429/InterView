package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/19 20:50
 */
public class 第46全排列 {
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> sub = new ArrayList<>();
//        for (int n : nums) {
//            sub.add(n);
//        }
//        dfs(ans, sub, nums.length, 0);
//        return ans;
//    }
//
//    private static void dfs(List<List<Integer>> ans, List<Integer> sub, int length, int index) {
//        if (index == length) {
//            ans.add(new ArrayList<>(sub));
//        }
//        for (int i = index; i < length; i++) {   // 本次递归填下标为index处的数，使用swap节省空间复杂度
//            Collections.swap(sub, index, i);
//            dfs(ans, sub, length, index + 1);   // 填下标为index+1处的数
//            Collections.swap(sub, index, i);
//        }
//    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(ans, list, nums.length, 0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> list, int n, int index) {
        if (index == n) ans.add(new ArrayList<>(list));   // ArrayList加进ans   List<List<Intrger>>
        for (int i = index; i < n; i++) {
            Collections.swap(list, i, index);
            dfs(ans, list, n, index + 1);
            Collections.swap(list, i, index);   // 方便for循环的下一个i交换不同元素
        }
    }
}
