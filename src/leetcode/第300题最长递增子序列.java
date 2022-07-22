package leetcode;

/**
 * Topic
 * Description
 * 0 8 4 12 2 3 4 更新为 0 3 4 但是不影响结果【刚开始只维护0 4 12 更新12之前的（遇到比12大的也更新12），
 * 但是当更新到12这个位置后就说明找到更好的可以替代原来的上升子数组了】
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 10:33
 */
public class 第300题最长递增子序列 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) return 0;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];   // 没找到说明d[]里面的所有数都比nums[i]大，此时更新d[1]【nums[i]对应的是d[i+1]】
            }
        }
        return len;
    }
}
