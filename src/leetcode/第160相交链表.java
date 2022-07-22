package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/22 11:34
 */
public class 第160相交链表 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {   // 走一步由pA变为pA.next
            pA = pA == null ? headB : pA.next;   // 因为同时走完了a+b+c，正好到c的第一个节点，即相交点
            pB = pB == null ? headA : pB.next;   // 例题：都走完a+b+c=8步之后，都到相交点的前一个node
        }
        return pA;
    }
}
