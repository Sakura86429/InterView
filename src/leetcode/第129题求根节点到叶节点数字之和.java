package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/1 13:01
 */
public class 第129题求根节点到叶节点数字之和 {
    public static void main(String[] args) {

    }
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        if (root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        else return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
