package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/3 10:26
 */
public class 第24题两两交换链表中的节点 {
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode temp = dummyHead;
//        while (temp.next != null && temp.next.next != null) {
//            ListNode node1 = temp.next;
//            ListNode node2 = temp.next.next;
//            temp.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//            temp = node1;
//        }
//        return dummyHead.next;
//    }
//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null) return head;
//        ListNode next = head.next;
//        ListNode newNode = swapPairs(next.next);
//        next.next = head;   // 这两个先后顺序不影响结果，因为不涉及next和head结点的移动
//        head.next = newNode;
//
//        return next;
//    }

//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode prev = dummy;
//        while (prev.next != null && prev.next.next != null) {
//            ListNode tem = head.next.next;   // 防止找不到head.next.next这个节点
//            head.next.next = head;   // 实际上是对head.next.next这个节点操作
//            prev.next = head.next;
//            head.next = tem;
//            prev = head;
//            head = head.next;
//        }
//        return dummy.next;
//    }
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;   // 如果前两个head和head.next不为null，则这两个就可以交换，head.next.next进入下一次递归处理
//        ListNode next = head.next;
//        head.next = swapPairs(head.next.next);   // 返回上一层递归的头部作为后序连接
//        next.next = head;
//
//        return next;   // 从底层后序遍历返回交换后的后序头部
//    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && head.next != null) {
            ListNode tem = head.next.next;
            prev.next = head.next;   // 重复出现在找结点上
            head.next.next = head;
            head.next = tem;
            prev = head;
            head = tem;
        }
        return dummy.next;
    }

}
