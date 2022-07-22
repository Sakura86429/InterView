package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/19 16:04
 */
public class 第240题搜索二维矩阵2 {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] > target) y--;   // 这一列所有元素都>target，忽略这一列
            else x++;   // 这一行所有元素都< target，忽略这一行
        }
        return false;
    }
}
