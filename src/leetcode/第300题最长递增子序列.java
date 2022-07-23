package leetcode;

/**
 * Topic
 * Description   当存在重复元素的时候1 1 1 3 插入 2 的时候此方法也是可以找到 3 前面的那个 1，之后pos+1替换 3 为 2
 * 0 8 4 12 2 3 4 更新为 0 3 4 但是不影响结果【刚开始只维护0 4 12 更新12之前的（遇到比12大的也更新12），
 * 但是当更新到12这个位置后就说明找到更好的可以替代原来的上升子数组了】
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 10:33
 */
public class 第300题最长递增子序列 {
    public static void main(String[] args) {

    }
//    public int lengthOfLIS(int[] nums) {
//        int len = 1, n = nums.length;
//        if (n == 0) return 0;
//        int[] d = new int[n + 1];
//        d[len] = nums[0];
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > d[len]) {
//                d[++len] = nums[i];
//            } else {
//                int l = 1, r = len, pos = 0;
//                while (l <= r) {
//                    int mid = (l + r) >> 1;
//                    if (d[mid] < nums[i]) {
//                        pos = mid;
//                        l = mid + 1;
//                    } else {
//                        r = mid - 1;
//                    }
//                }
//                d[pos + 1] = nums[i];   // 没找到说明d[]里面的所有数都比nums[i]大，此时更新d[1]【nums[i]对应的是d[i+1]】
//            }
//        }
//        return len;
//    }

    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) return 0;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];   // 此处是++len
            } else {   // 此二分法如果没有上面的if，当i大于所有d[]的时候，将会返回d数组最后一个下标。因为有了上面的条件，所以d[pos+1不会越界]
                int l = 1, r = len, pos = 0;
                while (l <= r) {   // 二分法，在第一个递增列表中查找第一个比nums[i]小的元素   // l<=r有等号是方便只剩下一个元素的时候继续【比如 1 1 1 3 插入 2 只剩下3的时候再r=mid+1跳出while循环】
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {   // 中间的比i小，i应该在右边
                        pos = mid;
                        l = mid + 1;
                    } else {
                         r = mid - 1;   // 等于的时候也r=mid-1，不影响最后结果【1 1，或者1】
                    }
                }
                d[pos + 1] = nums[i];   // pos+1不会越界，因为else下，d[]中永远有比nums[i]大的存在
            }
        }
        return len;
    }
}
