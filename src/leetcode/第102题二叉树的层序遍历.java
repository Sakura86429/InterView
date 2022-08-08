package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/12 14:44
 */
public class 第102题二叉树的层序遍历 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;   // 不要忘了非空判断   // if定义的不是局部变量，但是while和for循环里面定义的是局部变量
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> sub = new ArrayList<>();   // while和for循环里面，声明和新建的都是局部变量
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();   // for循环里面新建的也是局部变量
                sub.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(sub);
        }
        return ans;
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {   // 广度优先
//        List<List<Integer>> ans = new ArrayList<>();
//        if (root == null) return ans;   // 非空判断
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> sub = new ArrayList<>();
//            for (int i = 0; i < levelSize; i++) {   // queue队列排队是先进先出
//                TreeNode node = queue.poll();
//                sub.add(node.val);
//                if (node.left != null) queue.offer(node.left);   // 先进先出所以先.left加进去
//                if (node.right != null) queue.offer(node.right);
//            }
//            ans.add(sub);
//        }
//        return ans;
//    }
}
