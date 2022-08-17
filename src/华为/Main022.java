package 华为;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/17 11:15
 */
public class Main022 {
    private static boolean haveLoop = false;
    private static Set<Integer> dependments;
    private static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> parents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parents.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(",");
            for (int j = 1; j < split.length; j++) {
                parents.get(i).add(Integer.parseInt(split[j]));
            }
        }
        dependments = new TreeSet<>();   // TreeSet默认自然排序，也即是升序
        dfs(parents, m, new boolean[n]);
        if (haveLoop) System.out.println(-1);
        else {
            Integer[] res = dependments.toArray(new Integer[0]);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
                if (i != res.length - 1) System.out.print(",");
            }
        }
    }

    private static void dfs(List<List<Integer>> parents, int i, boolean[] visited) {
        if (visited[i] == true) {
            haveLoop = true;
            return;
        }
        if (!haveLoop) {
            if (m != i) {
                dependments.add(i);
            }
            visited[i] = true;
            for (int j : parents.get(i)) {
                dfs(parents, j, visited);
            }
            visited[i] = false;
        }
    }
}
