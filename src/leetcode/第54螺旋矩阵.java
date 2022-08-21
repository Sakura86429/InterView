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
        int rows = matrix.length, columns = matrix[0].length;
        int l = 0, r = columns - 1, t = 0, b = rows - 1;   // 行从l-r，列从t-b
        while (l <= r && t <= b) {   // 最后偶数圈转完，直接进行1 2 4循环。   // 奇数圈转完，只进行进行1，或者
            for (int i = l; i <= r; i++) order.add(matrix[t][i]);
            for (int i = t + 1; i <= b; i++) order.add(matrix[i][r]);
            if (l < r && t < b) {   // 防止单行或者单列（==）的时候重复扫描
                for (int i = r - 1; i > l; i--) order.add(matrix[b][i]);
                for (int i = b; i > t; i--) order.add(matrix[i][l]);
            }
            l++;
            r--;
            t++;
            b--;
        }
        return order;
    }
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> order = new ArrayList<>();
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
//        int rows = matrix.length, columns = matrix[0].length;   // 行和列
//        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;   // 定义两个边的四个点下标
//        while (left <= right && top <= bottom) {   // 有等号，因为会出现奇数，只剩下最中间一个的情况
//            for (int column = left; column <= right; column++) {
//                order.add(matrix[top][column]);
//            }
//            for (int row = top + 1; row <= bottom; row++) {
//                order.add(matrix[row][right]);
//            }
//            if (left < right && top < bottom) {   // 使用<防止重复扫描
//                for (int column = right - 1; column > left; column--) {   // 最短的一条，不包括left
//                    order.add(matrix[bottom][column]);
//                }
//                for (int row = bottom; row > top; row--) {   // 从底到次顶
//                    order.add(matrix[row][left]);
//                }
//            }
//            left++;
//            right--;
//            top++;
//            bottom--;
//        }
//        return order;
//    }
}
