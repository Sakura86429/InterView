package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/30 15:11
 */
public class 第997题找到小镇的法官 {
    public static int findJudge(int n, int[][] trust) {
        List<List<Integer>> list = new ArrayList<>();   // 对象刚开始是null
        for (int i = 0; i < n; i++) {   // 初始化
            list.add(new ArrayList<Integer>());
        }
        for (int[] info : trust) {   // 存入度
            list.get(info[0] - 1).add(info[1] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int find(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];   // 存i的入度
        int[] outDegrees = new int[n + 1];   // 存i的出度
        for (int[] info : trust) {   // 使用for each遍历二维数组，记录居民i的出度、入度
            outDegrees[info[0]]++;
            inDegrees[info[1]]++;
        }
        for (int i = 1; i <= n; i++) {   // 一次遍历居民，找到同时符合1、2条件的居民i
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = new int[][]{{1, 3}, {2, 3}};
//        int ans = findJudge(n, trust);
        int ans = find(n, trust);
        System.out.println(ans);
    }
}
