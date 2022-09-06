package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/9/6 20:31
 */
public class 第09用两个栈实现队列 {
    public static void main(String[] args) {

    }
    class CQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;
        public CQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }
        public void appendTail(int value){
            inStack.push(value);
        }
        public int deleteHead() {
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()) return -1;
                while (!inStack.isEmpty()) outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }
}
