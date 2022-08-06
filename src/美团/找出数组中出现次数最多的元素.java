package 美团;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Topic 找出数组中出现次数最多的元素
 * Description 哈希
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/30 12:50
 */
public class 找出数组中出现次数最多的元素 {
//    public static int find(int[] arr) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int a : arr) {
//            int time = map.getOrDefault(a, 0) + 1;
//            map.put(a, time);   // key一样会冲掉原来的数，因为key的hashcode和equals一样
//        }
//        Collection<Integer> count = map.values();
//        int maxTime = Collections.max(count);   // 返回集合中的最大值
//        System.out.println("maxTime:" + maxTime);
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {   // 遍历map中的键值对
//            if (entry.getValue() == maxTime) {
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }
    public static void main(String[] args) {
        int[] array = { 2, 3, 1, 2, 2, 5, 6, 8, 2, 3, 2, 4, 2 };
        System.out.println(find(array));
        System.out.println(find(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    private static int find(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);   // 思想：把数组都装进去统计出现次数value和数字key，最后通过遍历可以取出来
        }

        int ans = 0, max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
