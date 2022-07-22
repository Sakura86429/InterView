package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/20 10:28
 */
public class 第47题全排列2 {
    public static void main(String[] args) {

    }
    boolean[] vis;   // 全局变量标记数组
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];   // 初始都为false
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);   // 对数字数组排序
        dfs(nums, ans, sub, nums.length, 0);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> sub, int length, int index) {
        if (index == length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            sub.add(nums[i]);
            vis[i] = true;
            dfs(nums, ans, sub, length, index + 1);
            vis[i] = false;
            sub.remove(index);
        }
    }
}
