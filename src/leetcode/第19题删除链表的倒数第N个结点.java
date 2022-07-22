package leetcode;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = getLenth(head);
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i <= l - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;

    }

    private int getLenth(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
}
