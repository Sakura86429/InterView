package 民生银行信用卡中心;

import java.util.Scanner;

/**
 * Topic
 * Description
 * 输入：100,4.8,20,10,5,5
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/7 14:26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split(",");
        double N = Float.parseFloat(arr[0]);
        N = N * 10000;
        double X = Float.parseFloat(arr[1]);
        int year = Integer.parseInt(arr[2]);
        double[] s = new double[arr.length - 3];
        for (int i = 3; i < arr.length; i++) {
            s[i - 3] = Float.parseFloat(arr[i]);
        }

        int preTime = s.length;
        int times = preTime;

        double sum = 0;
        for (int i = 1; i <= year; i++) {
            if ( i!=1 && (i - 1) % 5 == 0 && preTime > 0) {
                double y = N * X / 100;
//                System.out.println(N * X);
                sum += y;
                double n = N / 500;
                N = N - n - Float.parseFloat(arr[times - preTime]) * 10000;
                preTime--;
                for (int j = 2; j <= 12; j++) {
                    y = N * X / 100;
                    sum += y;
                    n = N / 500;
                    N = N - n;
                }
            } else {
                for (int j = 1; j <= 12; j++) {
                    double y = N  * X / 100;
                    sum += y;
                    double n = N / 500;
                    N = N - n;
                }
            }
        }
        String result = String.format("%.2f", sum);
        System.out.println(result);
    }
}
