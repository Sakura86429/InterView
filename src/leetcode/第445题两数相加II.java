package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/24 14:26
 */
public class 第445题两数相加II {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.poll();
            int cur = a + b + carry;
            carry = cur / 10;   // 求进位
            cur %= 10;   // 保留低位
            ListNode node = new ListNode(cur);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}
