package leetcode;

import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/13 15:43
 */
public class 第19题删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int l = getLenth(head);
//        ListNode dummy = new ListNode(0, head);
//        ListNode cur = dummy;
//        for (int i = 1; i <= l - n; i++) {
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        return dummy.next;
//
//    }
//
//    private int getLenth(ListNode head) {
//        int l = 0;
//        while (head != null) {
//            l++;
//            head = head.next;
//        }
//        return l;
//    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode ans = head;
//        for (int i = 0; i < n; i++) {
//            fast = fast.next;   // 移动fast指针
//        }
//        while (fast.next != null) {   // 跑到了倒数第n个节点之前的一个node【使用next无法处理[1]1的情况】所以要用哑节点 ❌
//            fast = fast.next;
//            slow = slow.next;
//        }
////        ListNode temp = slow.next;
//        slow.next = slow.next.next;   // 如果不使用哑结点的话，这里删除不掉[1]1的情况，因为找不到1前面的一个节点！！！
////        temp.next = null;
//        return ans;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {   // 因为slow在head的前一个，所以比如【1 2 3】 1 当fast到达null的时候，slow到达的3的前一个2这里
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;   // 1-->2-->3将1-->3之后，2和3之间的指向断开
        slow.next = slow.next.next;
        temp.next = null;
        return dummy.next;
    }
}
