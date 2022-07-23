package leetcode;

/**
 * Topic
 * Description
 * 找到链表中间节点+反转链表+合并链表
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/23 11:09
 */
public class 第143重排链表 {
    public static void main(String[] args) {

    }
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;   // 用到了右半边【示例：长度为4用倒数2个，长度为5用倒数2】
        mid.next = null;   // 因为是单向-->连接，所以.next就可以直接切断
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Next;
        ListNode l2Next;
        while (l1 != null && l2 != null) {   // 奇偶都可以，当合出来的长为2、3的时候都只经过一次while循环【此处也用&&，必须都不为null，有一个为null表示已经结束】
            l1Next = l1.next;
            l2Next = l2.next;

            l1.next = l2;
            l1 = l1Next;

            l2.next = l1;
            l2 = l2Next;
        }
    }

    private ListNode reverseList(ListNode l2) {   // 反转链表：单向连接-->，先存下curr.next接着改变next指向：curr.next=prev；再移动prev和curr
         ListNode prev = null;
         ListNode curr = l2;
         while (curr != null) {
             ListNode temp = curr.next;
             curr.next = prev;
             prev = curr;
             curr = temp;
         }
         return prev;
    }

    private ListNode middleNode(ListNode head) {   // 奇数长返回中间Node引用，偶数返回firstEnd
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {   // 偶数2个不经过循环直接返回slow；奇数循环一次就返回slow指向中间【此处用&&】
            slow = slow.next;   // 移动slow引用
            fast = fast.next.next;   // 移动fast引用
        }
        return slow;
    }
}
