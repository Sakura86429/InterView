package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/18 10:20
 */
public class 第200题岛屿数量 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {}
        };
    }
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) return 0;
//        int nr = grid.length;
//        int nc = grid[0].length;
//        int numIslands = 0;
//        for (int r = 0; r < nr; r++) {
//            for (int c = 0; c < nc; c++) {
//                if (grid[r][c] == '1') {
//                    numIslands++;
//                    dfs(grid, r, c);
//                }
//            }
//        }
//        return numIslands;
//    }
//
//    private void dfs(char[][] grid, int r, int c) {
//        int nr = grid.length;
//        int nc = grid[0].length;
//        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
//            return;
//        }
//        grid[r][c] = '0';
//        dfs(grid, r - 1, c);
//        dfs(grid, r + 1, c);
//        dfs(grid, r, c - 1);
//        dfs(grid, r, c + 1);
//    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {   // 字符和数字都用==
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
