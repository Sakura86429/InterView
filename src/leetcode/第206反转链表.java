package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/20 15:21
 */
public class 第206反转链表 {
    public static void main(String[] args) {

    }
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode tem = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = tem;
//        }
//        return prev;
//    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reversePrev = reverseList(head.next);
        head.next.next = head;
        head.next = null;   // 如果这一步少了就会有环？
        return reversePrev;
    }
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
//        return prev;
//    }
//    // 递归法
//    public ListNode reverseList2(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode newHead = reverseList2(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
}
