package 猿辅导;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/7 20:13
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        List<String> ans = new ArrayList<>();
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.length() != 1) continue;
            else {
                int m = Integer.parseInt(str);
                String[] ansM = new String[m];
                for (int i = 0; i < m; i++) {
                    ansM[i] = sc.next();
                }
                int nn = sc.nextInt();

                for (int i = 0; i < nn; i++) {
                    StringBuffer sbuffer = new StringBuffer();
                    int x = sc.nextInt();
                    String[] sub = new String[x];
                    for (int j = 0; j < x; j++) {
                        sub[j] = sc.next();
                    }
                    for (int j = 0; j < x; j++) {
                        if (j == x-1) {
                            sbuffer.append(sub[j]);
                        } else sbuffer.append(sub[j] + " ");
                    }
                    String subAns = sbuffer.toString();
                    ans.add(subAns);
                }
                for (int i = 0; i < m; i++) {
                    ans.add(ansM[i]);
                }
                break;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
