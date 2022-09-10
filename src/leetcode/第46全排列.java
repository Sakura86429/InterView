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

        System.out.println(new 第46全排列().permute(new int[]{1,2,3}));
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

//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> ans = new LinkedList<>();
//        List<Integer> list = new LinkedList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        dfs(ans, list, nums.length, 0);
//        return ans;
//    }
//
//    private static void dfs(List<List<Integer>> ans, List<Integer> list, int n, int index) {
//        if (index == n) ans.add(new ArrayList<>(list));   // ArrayList加进ans   List<List<Intrger>>
//        for (int i = index; i < n; i++) {
//            Collections.swap(list, i, index);
//            dfs(ans, list, n, index + 1);
//            Collections.swap(list, i, index);   // 方便for循环的下一个i交换不同元素
//        }
//    }

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> sub = new ArrayList<>();
//        for (int num : nums) sub.add(num);
//        dfs(res, sub, sub.size(), 0);
//        return res;
//    }
//
//    private void dfs(List<List<Integer>> res, List<Integer> sub, int length, int index) {
//        if (index == length - 1) {   // 交换完1下标，+1=2的时候就可以收了
////            res.add(sub);   // 使用这个的时候不会有任何变化，会一直添加[1, 2, 3]
//            res.add(new ArrayList<>(sub));   // 传入参数add的时候，add的加是真的添加进去了，与形参无关
//            return;
//        }
//        for (int i = index; i < length; i++) {   // i从index开始往后交换
//            Collections.swap(sub, index, i);
//            dfs(res, sub, length, index + 1);
//            Collections.swap(sub, index, i);   // 方便下一次for循环交换元素
//        }
//    }
    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            dfs(res, list, nums.length, 0);
            return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sub, int length, int index) {
        if (index == length - 1) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = index; i < length; i++) {
            Collections.swap(sub, index, i);
            dfs(res, sub, length, index + 1);
            Collections.swap(sub, index, i);
        }
    }
}
