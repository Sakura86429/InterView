package leetcode;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/16 16:16
 */
public class 第79题单词搜索 {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {   // 在board[i][j] = s.charAt(k)的时候才有这个判断，此时的k应该等于s.length()-1，还没有来得及加到length
            return true;
        }
        visited[i][j] = true;   // 如果不等就直接返回false了，不会使visit[i][j]变true。如果从这一个ij的不行，则这一个ij的visit会变成false。这条线上的都会变成false
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {   // 每一个方向都调用check函数
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);   // 返回值flag是一直到最后的if-else判断return ture或其他
                    if (flag) {
                        result = true;   // 如果最深层返回true，则visit=false逐层返回result=true
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;   // 这一次深搜是否成功都会变为false
        return result;
    }
}
