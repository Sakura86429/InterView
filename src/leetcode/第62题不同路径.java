package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/25 21:49
 */
public class 第62题不同路径 {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {   // 按行i++填满第一列
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {   // 按列j++填满第一行
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {   // 按i++开始逐列填dp次数矩阵
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];   // 除了第一行和第一列的[i][j]位置有可能从i-1下移，或者j-1右移动【因为机器人每次只能右移或下移】
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
//            ans *= x / y;
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
