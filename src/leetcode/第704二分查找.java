package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/1 10:21
 */
public class 第704二分查找 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -  1;
        while (l <= r) {   // 如果单个[a]=target，就直接返回。如果单个不是就会退出返回-1。 // 如果偶数[a=0, b=1]不超区间的时候也能找到b=target=1，奇数也是一样
            int mid = (r - l) / 2 + l;   // 等价于(l + r) / 2，但是这个一般不会超范围
            int num = nums[mid];
            if (num == target) return mid;
            else if (num < target) l = mid + 1;   // 要使区间趋向target，调整 l 范围
            else r = mid - 1;
        }
        return -1;
    }
}
