package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/10 15:45
 */
public class 第228题汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {   // 如果此处的i==i-1处+1，继续while
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));   // 存low
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));   // 存high
            }
            ret.add(temp.toString());   // StringBuffer有函数toString()可以转为String
        }
        return ret;
    }
}
