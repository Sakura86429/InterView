package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 18:01
 */
public class 第21题合并两个有序链表 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode prev = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;   // 移动引用
        }
        prev.next = l1 == null ? l2 : l1;
        return ans.next;

    }
}
