package leetcode;

/**
 * Topic
 * Description
 * 如果圈很小的时候，快指针可能已经走了N圈了
 * // 此时圈可能很小，我也不知道n-1是多少圈，但是只要走下一次相等总会碰到
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/17 19:16
 */
public class 第142环形链表2 {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else return null;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {   // 此时圈可能很小，我也不知道n-1是多少圈，但是只要走，总会走完c+（n-1）（b+c），所以总会碰到
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
