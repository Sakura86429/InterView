package leetcode;

import java.util.*;

/**
 * Topic
 * Description
 * 双端队列来存入ans
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/21 12:47
 */
public class 第103题二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;   // 从左-->右扫描
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();   // 即弹出了元素，有可以接到弹出的元素TreeNode
                if (isOrderLeft) levelList.offerLast(node.val);   // 本身queue是左，右遍历的。所以加到双端队列末尾相当于把left往左挤
                else levelList.offerFirst(node.val);   // 加到头部相当于把left往右挤
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(new LinkedList<>(levelList));   // new LinkedList也可以加入List<Integer>
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
