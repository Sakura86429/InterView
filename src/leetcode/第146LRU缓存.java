package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic
 * Description
 * 手写一个双向链表，手动连接head.next=tail;tail.prev=head然后使用Map，Integer存key，DLinkedNode存value
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/15 11:24
 */
public class 第146LRU缓存 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) { this.key = key; this.value = value;}
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<>();   // cache是一个map存储key和DLinkedNode
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public 第146LRU缓存(int capacity) {   // 构造器
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪头节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);   // 删除 + 添加到head与head.next之间
        return node.value;
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {   // 如果key不存在
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {   // 如果key存在，移动到head位置
            node.value = value;   // 修改value
            moveToHead(node);   // 将原node移除，并移动到head的后面一个位置
        }
    }


    // 基础函数1
    private void removeNode(DLinkedNode node) {   // 功能：根据node.prev和node.next删除单个节点node【两个节点之间只有prev和next连接】
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // 基础函数2
    private void addToHead(DLinkedNode node) {   // 添加到head的后面一个位置【将node插入到head与head.next之间，2个连接变4个】
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {   // 删除尾部的节点（即tail的前一个节点）
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

}
