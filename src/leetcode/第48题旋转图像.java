package leetcode;

/**
 * Topic
 * Description
 * 主对角线是斜向右下的那条
 * @author zhouh
 * @version 1.0
 * Create by 2022/5/19 21:10
 */
public class 第48题旋转图像 {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {   // n行   // 沿水平轴翻转（行变列不变）
            for (int j = 0; j < n; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tem;
            }
        }
        for (int i = 0; i < n; i++) {   // 沿主对角线（\）旋转（行列互换）
            for (int j = 0; j < i; j++) {   // 第一行不满足j<0不交换，第二行只交换一次...
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
    }
}
