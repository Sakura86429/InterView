package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/18 10:17
 */
public class 第34题在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = binarySearch(nums, target, true);
        int endIndex = binarySearch(nums, target, false) - 1;
        if (startIndex <= endIndex && endIndex < nums.length && nums[startIndex] == target && nums[endIndex] == target) {
            return new int[]{startIndex, endIndex};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0, right = nums.length - 1, ans = nums.length;   // 此处初始ans=nums.length应对数组只有一个元素[1]，endIndex则会直接返回ans-1=0，而不是0-1=-1
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (flag && nums[mid] >= target)) {   // 当为true的时候，如果nums[mid]==target，继续right=mid-1、保存此次的ans、right左移动，直到找到startIndex
                right = mid - 1;   // 当为false的时候，只有nums[mid]>target才会左移right，保存ans；最后会保存第一个>target的ans
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
