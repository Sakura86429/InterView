package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/4/25 9:45
 */
public class 第56题合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];   // 谁在右边谁大：o2[0]大的顺序
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
            }
        }
        return ans.toArray(new int[ans.size()][2]);   // List转数组
    }
    public static void main(String[] args) {

    }
}
