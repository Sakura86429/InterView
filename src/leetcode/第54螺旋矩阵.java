package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/22 15:23
 */
public class 第54螺旋矩阵 {
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int rows = matrix.length, columns = matrix[0].length;   // 行和列
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;   // 定义两个边的四个点下标
        while (left <= right && top <= bottom) {   // 有等号，因为会出现奇数，只剩下最中间一个的情况
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {   // 使用<防止重复扫描
                for (int column = right - 1; column > left; column--) {   // 最短的一条，不包括left
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {   // 从底到次顶
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
