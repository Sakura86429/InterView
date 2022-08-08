package 猿辅导;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/7 19:45
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            String str = sc.next();
            int[] strNumber = new int[26];
            for (int k = 0; k < str.length(); k++) {
                int index = str.charAt(k) - 'a';
                strNumber[index]++;
            }

            int N = sc.nextInt();
            String[] sub = new String[N];
            for (int j = 0; j < N; j++) {
                sub[j] = sc.next();
            }
            int[] max = new int[N];
            for (int k = 0; k < N; k++) {
                max[k] = Integer.MAX_VALUE;
            }
            for (int k = 0; k < N; k++) {
                String s = sub[k];
                int[] ss = new int[26];
                for (int m = 0; m < s.length(); m++) {
                    int index = s.charAt(m) - 'a';
                    ss[index]++;
                }
                for (int m = 0; m < 26; m++) {
                    if (ss[m] != 0) {
                        if (strNumber[m] == 0) {
                            max[k] = 0;
                            break;
                        } else max[k] = Math.min(max[k], strNumber[m]/ss[m]);
                    }
                }
            }
            Arrays.sort(max);   // 时间按复杂度nlogn会变慢
            ans[i] = max[max.length - 1];
        }
        for (int i = 0; i < M; i++) {
            System.out.println(ans[i]);
        }
    }
}
