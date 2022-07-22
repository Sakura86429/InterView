package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description 目的是为了深搜，所以这里要清掉，不然由于会多加一个sub影响上一层
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/18 10:59
 */
public class 第39题组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(candidates, target, ans, sub, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> sub, int index) {
        if (index == candidates.length) return;   // 递归终止条件1：candidates数组被全部用完
        if (target == 0) {   // 递归条件2：target==0
            ans.add(new ArrayList<>(sub));
            return;
        }
        dfs(candidates, target, ans, sub, index + 1);   // 跳过不用index下标的数
        if (target - candidates[index] >= 0) {
            sub.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, sub, index);   // 使用当前index下标的数
            sub.remove(sub.size() - 1);   // 因为sub只有一个在前面定义的全局变量，所以每次递归target-candidates[index]后，删掉前两行添加的sub.add(candidates[index])
            // 因为判断后是先add再dfs的，所以最后dfs的下一层也会加上candidates[index]，
            // 由于递归是先递归到最深的dfs函数，再往上计算，所以最底层的上一层就会多一个candidates[index]
            // 再往上逐层都多一个candidates[index]

            // 如果是针对index+1的递归，不remove的话会多累计很多

            // 目的是为了深搜，所以这里要清掉，不然由于会多加一个sub影响上一层
        }
    }
}
