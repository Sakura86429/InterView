package leetcode;

/**
 * Topic
 * Description
 * 时间复杂度N：当快慢在起点也是圈内的时候同时出发，最多移动N追上，此时慢走一圈，快走两圈
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/17 19:13
 */
public class 第141环形链表 {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
