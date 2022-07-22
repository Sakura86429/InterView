package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/26 20:56
 */
public class 第78题子集 {
    public static void main(String[] args) {

    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int index, int[] nums) {
        if (index == nums.length) {   // 当其执行完sub.add()后进入dfs就会输出
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        dfs(index + 1, nums);
        sub.remove(sub.size() - 1);   // remove掉sub.size() - 1更保险一些，移除的是前面行添加的nums[index]
        dfs(index + 1, nums);
    }
}
