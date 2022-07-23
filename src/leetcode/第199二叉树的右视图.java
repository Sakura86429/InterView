package leetcode;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/23 13:09
 */
public class 第199二叉树的右视图 {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.add(root);
        int maxDepth = -1;
        depthStack.add(0);
        while (!nodeStack.isEmpty()) {   // 通过深度栈和结点栈来进行遍历，每次每个depth只添加一个
            int depth = depthStack.pop();
            TreeNode node = nodeStack.pop();
            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                if (!map.containsKey(depth)) {
                    map.put(depth, node.val);
                }
                nodeStack.add(node.left);
                nodeStack.add(node.right);
                depthStack.add(depth + 1);
                depthStack.add(depth + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int depth = 0; depth <= maxDepth; depth++) {
            ans.add(map.get(depth));
        }
        return ans;
    }
}
