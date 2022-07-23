package leetcode;

import java.util.Stack;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/23 11:38
 */
public class 第232用栈实现队列 {
    public static void main(String[] args) {

    }
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;
    public 第232用栈实现队列() {
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {   // s2为空，需要弹入s1的元素，再s2.pop()
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();   // s1和s2都为空，或者s2不为空，直接弹出s2就可以了
    }

    public int peek() {   // 返回最先入队的那个元素【队列开头的元素】
        if (!s2.isEmpty()) return s2.peek();
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
