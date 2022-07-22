package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/11 16:49
 */
public class 第2题两数相加 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;   // 第一次进位为0
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;   // 之后用carry = sum / 10查看是否有进位
            if (head == null) {
                head = tail = new ListNode(sum % 10);   // 第一个直接head=tail赋值
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;   // 第二个移动tail的引用
            }
            carry = sum / 10;   // 0-9为0，10+输出进位1。每一次的进位都由sum/10再次得到
            if (l1 != null) {   // 每一轮结束后为null的一个listnode不动，移动不为null的一个
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {   // 进位>0，再接一个tail.next()
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
