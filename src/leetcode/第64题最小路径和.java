package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/25 10:31
 */
public class 第64题最小路径和 {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];   // 初始化左上角第一个元素
        for (int i = 1; i < rows; i++) {   // 填dp矩阵的第一列，从下标1开始
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {   // 填dp矩阵的第一行，从下标1开始
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {   // 一行一行的填剩余的地方
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
