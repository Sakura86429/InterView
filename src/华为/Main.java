package 华为;

import java.util.*;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/17 9:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        List<String> titles = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] title = sc.nextLine().split(" ");
            Collections.addAll(titles, title);
            String[] content = sc.nextLine().split(" ");
            Collections.addAll(contents, content);
        }
        Map<String, int[]> articleMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < titles.size(); j++) {
                String s = titles.get(j);
                if (!articleMap.containsKey(s)) {
                    articleMap.put(s, new int[6]);
                }
                int[] info = articleMap.get(s);
                info[1] = info[1] + 1;
                info[3] = Math.max(info[3], Integer.MIN_VALUE - j - 1);
            }
            for (int j = 0; j < contents.size(); j++) {
                String s = contents.get(j);
                if (!articleMap.containsKey(s)) {
                    articleMap.put(s, new int[6]);
                }
                int[] info = articleMap.get(s);
                info[2] = info[2] + 1;
                info[4] = Math.max(info[3], Integer.MIN_VALUE - j - 1);
            }
        }
        int n = articleMap.size();
        String[] keys = articleMap.keySet().toArray(new String[0]);
        int[][] articleRecords = new int[n][6];
        for (int i = 0; i < keys.length; i++) {
            articleRecords[i] = articleMap.get(keys[i]);
            articleRecords[i][0] = articleRecords[i][1] * 3 + articleRecords[i][2];
            articleRecords[i][5] = i;
        }
        Arrays.sort(articleRecords, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < 6; i++) {
                    if (o1[i] - o2[i] != 0) return o2[i] - o1[i];
                }
                return 0;
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.print(keys[articleRecords[i][5]]);
            if (i != N - 1) System.out.print(" ");
        }
    }
}
