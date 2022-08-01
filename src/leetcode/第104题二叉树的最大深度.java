package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/1 11:38
 */
public class 第104题二叉树的最大深度 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lH = maxDepth(root.left);
        int rH = maxDepth(root.right);
        return Math.max(lH, rH) + 1;
    }
}
