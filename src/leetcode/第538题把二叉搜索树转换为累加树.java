package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/19 16:22
 */
public class 第538题把二叉搜索树转换为累加树 {
    public static void main(String[] args) {

    }
    // 反序中序遍历
    int sum = 0;
    public TreeNode convertBST1(TreeNode root) {
        if (root != null) {
            convertBST1(root.right);
            sum += root.val;
            root.val = sum;
            convertBST1(root.left);
        }
        return root;   // 可以return root，只要onvertBST1(root.right);不接也没事
    }
}
