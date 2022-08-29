package leetcode;

/**
 * Topic
 * Description
 * 双指针，时间复杂度为n；否则暴力时间复杂度为n^2
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/29 16:59
 */
public class 第11题盛水最多的容器 {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }
}
