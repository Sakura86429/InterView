package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/20 14:06
 */
public class 第59题螺旋矩阵2 {
    public static void main(String[] args) {

    }
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1;
        int t = 0, b = n - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) matrix[t][l] = num++;
            for (int i = t; i <= b; i++) matrix[t][r] = num++;
            if (l < r && t < b) {   // 两者如果只有一条满足，就是行或列
                for (int i = r - 1; i > l; i--) matrix[b][i] = num++;
                for (int i = b; i > t; i--) matrix[i][l] = num++;
            }
            l++;
            r--;
            t++;
            b--;
        }
        return matrix;
    }
}
