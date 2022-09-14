package leetcode;

//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/6/10 10:59
 */
public class 第144题二叉树的前序遍历 {
    public static void main(String[] args) {

    }
//    private void preorder(TreeNode root, List<Integer> ans) {
//        if (root == null) return;
//        ans.add(root.val);
//        preorder(root.left, ans);
//        preorder(root.right, ans);
//    }
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        preorder(root, ans);
//        return ans;
//    }

//    private void preorder(TreeNode root, List<Integer> ans) {
//        if (root == null) {
//            return;
//        }
//        ans.add(root.val);
//        preorder(root.left, ans);
//        preorder(root.right, ans);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
