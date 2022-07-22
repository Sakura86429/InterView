//package leetcode;
//
//import javax.swing.tree.TreeNode;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Topic
// * Description
// *
// * @author zhouh
// * @version 1.0
// * Create by 2022/3/31 15:00
// */
//public class 第105题从前序与中序遍历序列构造二叉树 {
//    Map<Integer, Integer> map = new HashMap<>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {   // 构造哈希映射，帮助我们快速定位根节点
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        int n = inorder.length;
//        return buildTree(preorder, inorder, 0, n - 1, 0, n -1);
//    }
//
//    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
//        if (pre_start > pre_end) return null;
//
//        // 只用到了root，root_index
////        TreeNode root = new TreeNode(preorder[pre_start]);   // 构建根节点root
//        int root_index = map.get(preorder[pre_start]);   // 从哈希映射中找到root_index
//        int left_number = root_index - in_start;   // 找到本次迭代中左子树的长度
//        // 递归找到root.left，当左子树数量=0的时候，pre_start + 1 > pre_start + left_number，找到了return条件
//        root.left = buildTree(preorder, inorder, pre_start + 1, pre_start + 1 + left_number - 1, in_start, root_index - 1);
//        root.right = buildTree(preorder, inorder, pre_start + left_number + 1, pre_end, root_index + 1, in_end);
//        return root;
//    }
//}
