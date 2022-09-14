package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/1 10:06
 */
public class 第94二叉树的中序遍历 {
    public static void main(String[] args) {

    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        dfs(root, ans);
//        return ans;
//    }
//
//    private void dfs(TreeNode root, List<Integer> ans) {
//        if (root == null) return;
//        dfs(root.left, ans);
//        ans.add(root.val);
//        dfs(root.right, ans);
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);   // 每一个结点寻找左-根-右添加，直到add(根)
        dfs(root.right, res);
    }
}
