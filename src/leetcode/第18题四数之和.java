package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/16 10:12
 */
public class 第18题四数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> ans = fourSum(nums, 0);
        for (List<Integer> sub : ans) {
            for (Integer n : sub) {
                System.out.print(n + " ");
            }
            System.out.println("");
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (length < 4) return list;
        Arrays.sort(nums);   // 先排序
        for (int i = 0; i < length - 3; i++) {   // <length能取到倒数第一个元素，<length-3能取到倒数第四个元素（前面还有3个元素没取到）
            if (i > 0 && nums[i] == nums[i - 1]) continue;   // 同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素。【因为一次i之后的元素上一次通过j=i+1已经枚举过了】
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;   // 剪枝：如果前面4个之和【最小的4个和】>target，说明后面的循环i也没有机会==了
            if ((long) nums[i] + nums[length- 1] + nums[length- 2] + nums[length- 3] < target) continue;   // 本次nums[i]加上倒数三个【本次最大的4个和，淘汰本次后面的枚举】<target，说明本次i加上不是倒数三个的元素也不会==target了
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[length- 1] + nums[length- 2] < target) continue;
                int left = j + 1, right = length- 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left + 1 < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        while (left < right - 1 && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
