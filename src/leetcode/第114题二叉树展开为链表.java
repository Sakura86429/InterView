package leetcode;

import leetcode.TreeNode;
/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/6/10 10:57
 */
public class 第114题二叉树展开为链表 {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {   // 找到cur左子树的前序最后一个节点
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;   // 连接cur子树前序的最后一个节点和右子树
                curr.left = null;   // 部分伸展
                curr.right = next;
            }
            curr = curr.right;   // cur.right也即使是原来cur的左节点，之后继续往左遍历，连接左子树最右边节点和其它部分【遍历到最后总会伸展完】
        }
    }

//    public void flatten2(TreeNode root) {
//        TreeNode curr = root;
//        while (curr != null) {
//            if (curr.left != null) {
//                TreeNode next = curr.left;
//                TreeNode pre = next;
//                while (pre.right != null) {
//                    pre = pre.right;
//                }
//                pre.right = curr.right;
//                curr.left = null;
//                curr.right = next;
//            }
//            curr = curr.right;
//        }
//    }

}
