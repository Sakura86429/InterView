package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Topic
 * Description   数组中前k个高频元素
 * 使用优先级队列维护一个小顶堆
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/17 16:59
 */
public class 第347题前k个高频元素 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        for (int a : ans) System.out.println(a);
    }
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : nums) {   // 记录数组中各个int出现的次数
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {   // 优先级队列中元素为一个2元素数组[num, count]
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];   // 优先级队列中数组元素，按照索引[1]（次数）从小到大
//            }
//        });
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {   // 遍历k个不同的数字
//            int num = entry.getKey(), count = entry.getValue();
//            if (queue.size() == k) {
//                if (count > queue.peek()[1]) {
//                    queue.poll();
//                    queue.add(new int[]{num, count});
//                }
//            } else {
//                queue.offer(new int[]{num, count});
//            }
//        }
//        // 返回数组
//        int[] ret = new int[k];
//        for (int i = 0; i < k; i++) {
//            ret[i] = queue.poll()[0];   // 弹出栈顶元素
//        }
//        return ret;
//    }
//
//    public int[] topKFrequent2(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];   // 后面的更大
//            }
//        });
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int num = entry.getKey(), count = entry.getValue();
//            if (queue.size() == k) {
//                if (queue.peek()[1] < count) {
//                    queue.poll();   // 弹出堆顶
//                    queue.offer(new int[] {num, count});   // 弹入新元素
//                }
//            } else {
//                queue.offer(new int[] {num, count});
//            }
//        }
//        int[] ret = new int[k];
//        for (int i = 0; i < k; i++) {
//            ret[i] = queue.poll()[0];
//        }
//        return ret;
//    }
    public static int[] topKFrequent(int[] nums, int k) {   // 说明了k的范围为1开始
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), val = entry.getValue();
            if (queue.size() < k) {
                queue.offer(new int[] {num, val});
            } else if (queue.size() == k && queue.peek()[1] < val) {   // 警告：这里有可能k=0执行queue.peek()[1]出错
                queue.poll();
                queue.offer(new int[] {num, val});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

}
