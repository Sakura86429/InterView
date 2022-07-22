package 剑指offer;

/**
 * Topic
 * Description 主对角线是斜向右下的那条
 * https://leetcode.cn/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/19 13:05
 */
public class 旋转矩阵 {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {   // 下标 【中间】 和 【上半部分end】
            for (int j = 0; j < n; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];   // 下标要-1，想一下就可以写好了
                matrix[n - i - 1][j] = tem;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; i++) {   // 主对角线下半部分，当i=1，j只能0；i=2，j只能0，1
            for (int j = 0; j < i; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
    }
}
