package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/1 10:39
 */
public class 第82题删除排序链表中的重复元素II {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {   // 加入有一个元素直接返回了；假如有1-->1两个重复元素，直接next和next.next就都指向1了；
            // 由此地推从前往后是成立的
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) cur.next = cur.next.next;   // 这里是删除cur.next比较方便。
                // 这里是所有重复的都会被删除，例如[1, 1, 2, 3]输出[2, 3]
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
