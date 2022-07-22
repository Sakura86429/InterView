package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/28 11:04
 */
public class 第128题最长连续序列 {
    public static void main(String[] args) {
        int[] nums = new int[] {100,4,200,1,3,2};
        System.out.println(longestConsecutive2(nums));
    }
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {   // 去重，且查询在不在的时间复杂度为O(1)
            set.add(num);
        }
        int longest = 0;   // 初始化最终返回值，进入for循环后会longest = Math.max(longest, current);更新
        for (int num : set) {   // 遍历set哈希集合   // for循环中的每一个num都是新的，和上一次的num不冲突，类似于局部变量
            if (!set.contains(num - 1)) {
//                int curNum = num;   // 存储当前num，进入后面的while循环
                int current = 1;   // 给num流长度变为1
                while (set.contains(num + 1)) {
                    num += 1;
                    current += 1;
                }
                longest = Math.max(longest, current);
            }
        }
        return longest;
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {   // 去重，且查询在不在的时间复杂度为O(1)
            set.add(num);
        }
        int longest = 0;   // 初始化最终返回值，进入for循环后会longest = Math.max(longest, current);更新
        for (int num : set) {   // 遍历set哈希集合
            if (!set.contains(num - 1)) {
                int curNum = num;   // 存储当前num，进入后面的while循环
                int current = 1;   // 给num流长度变为1
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    current += 1;
                }
                longest = Math.max(longest, current);
            }
        }
        return longest;
    }
}
