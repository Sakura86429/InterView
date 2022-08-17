package 华为;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/17 15:16
 */
public class Main023 {
    public static Set<Integer> res;
    public static boolean haveLoop = false;
    public static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();   // 必须写在这里，不然会按照int定义，就不是全局变量不是紫色了

        sc.nextLine();
        List<List<Integer>> parents = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            parents.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(",");
            for (int j = 1; j < str.length; j++) {
                parents.get(i).add(Integer.parseInt(str[j]));
            }
        }
        res = new TreeSet<>();
        dfs(parents, M, new boolean[N]);
        if (haveLoop) System.out.println(-1);
        else {
            Integer[] ans = res.toArray(new Integer[0]);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i]);
                if (i != ans.length - 1) System.out.print(",");
            }
        }
    }

    private static void dfs(List<List<Integer>> parents, int i, boolean[] visited) {
        if (visited[i] == true) {
            haveLoop = true;
            return;
        }
        if (!haveLoop) {
            if (i != M) {
                res.add(i);
            }
            visited[i] = true;
            for (int j : parents.get(i)) {
                dfs(parents, j, visited);
            }
            visited[i] = false;
        }

    }

}
