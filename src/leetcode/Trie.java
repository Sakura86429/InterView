package leetcode;

//import sun.text.normalizer.Trie;

/**
 * Topic leetcode 208
 * Description
 * 数组每一个索引都有|T|的空间复杂度
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/19 13:16
 */
public class Trie {
    public static void main(String[] args) {

    }
    private Trie[] children;
    private boolean isEnd;

    public Trie() {   // 包含两个成员变量【3个函数复杂度最小就使用int[26]数组】，(只是)实现一个类
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;   // this指示对象？
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();   // 存一个节点，children数组每一个下标都存一个new Trie()出来的对象
            }
            node = node.children[index];   // 逐渐移动到前缀末尾，方便调整前缀末尾isEnd为true
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    private Trie searchPrefix(String prefix) {   // 检查前缀是否存在，存在就返回前缀末尾，不存在返回null
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
