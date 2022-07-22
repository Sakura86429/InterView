package leetcode;

import java.util.HashMap;

/**
 * Topic 和为k的 连续子数组
 * Description 有负数
 * 那么[j..i] 这个子数组和为 k 这个条件我们可以转化为, 通过哈希表存在pre - k可知，一定存在包含i的子区间和为k
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 11:30
 */
public class 第560题和为k的子数组 {
    public static void main(String[] args) {

    }
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // 定义（0，1）找第一个符合条件的带有i的连续子数组
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
