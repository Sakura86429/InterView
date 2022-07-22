package leetcode;



/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/28 9:50
 */
public class 第236题二叉树的最近公共祖先 {
//    private static TreeNode ans;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root, p, q);
//        return ans;
//    }
//    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return false;
//        boolean lson = dfs(root.left, p, q);
//        boolean rson = dfs(root.right, p, q);
//        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {   // 找到ans
//            ans = root;
//        }
//        return lson || rson || (root.val == p.val || root.val == q.val);   // 返回条件
//    }

    public static void main(String[] args) {

    }
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);   // 左子树是否出现p，q【包括左子树根节点root.left的值=p，q的情况】
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) ans = root;   // 因为题干要求所有val都不相同，所以不会再出现其他的情况
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
