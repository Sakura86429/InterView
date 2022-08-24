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
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);   // 对于数组使用Arrays.fill()函数
        dp[0] = 0;   // 方便dp[1]的1计算   // 当i==0时，无法用硬币组成
        for (int i = 1; i <= amount; i++) {   // 1-amount，动态规划本质上是暴力
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {   // 对于满足if的，单个i - coins[j]遍历
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];   // 如果最后的结果仍然是amount+1，说明结果凑不出
    }
}
