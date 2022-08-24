package leetcode;

import java.util.Arrays;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/24 13:50
 */
public class 第322题零钱兑换 {
    public static void main(String[] args) {

    }
//    public int coinChange(int[] coins, int amount) {
//        int max = amount + 1;
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, max);   // 对于数组使用Arrays.fill()函数
//        dp[0] = 0;   // 方便dp[1]的1计算   // 当i==0时，无法用硬币组成
//        for (int i = 1; i <= amount; i++) {   // 1-amount，动态规划本质上是暴力
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {   // 对于满足if的，单个i - coins[j]遍历
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];   // 如果最后的结果仍然是amount+1，说明结果凑不出
//    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {   // 遍历所有零钱
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);   // dp[i]还有可能轮到上一轮j的数
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
