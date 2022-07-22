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
 * Create by 2022/4/25 21:04
 */
public class 第15题三数之和 {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums);   // 排序nlogn

        for (int i = 0; i < nums.length; i++) {   // 时间复杂度n2
            if (nums[i] > 0) break;   // 第一个数大于0，后面两个数都大于0，且i后面肯定也>0，后面循环不成立
            if (i > 0 && nums[i] == nums[i - 1]) continue;   // 去重
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;right--;   // target一定，改变left肯定也要改变right，否则另一个数和上一次的一样了   // 去重
                    while (left < right && nums[left] == nums[left - 1]) left++;   // 去重
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;
        int n = nums.length;
        Arrays.sort(nums);   // 排序时间复杂度为nlogn
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;   // 第一个数大于0，后面两个数都大于0，且i后面肯定也>0，后面循环不成立
            if (i > 0 && nums[i] == nums[i - 1]) continue;   // 去重
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;   // 由两边往中间缩
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++; right--;   // 去重
                    while (left < right && nums[left] == nums[left - 1]) left++;   // 去重：去掉和上一个left即left-1重复的
                    while (left < right && nums[right] == nums[right + 1]) right--;   // 去重：去掉和上一个right即right+1重的
                } else if (nums[left] + nums[right] < target) {   // 整体小要变大，此时right已经到最右边了，只能加左边
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
