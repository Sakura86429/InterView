package leetcode;

/**
 * Topic
 * Description
 * 比它小的话就记录，比它大的话就比较。这样可以跳过 5 1 这种。5 1 只会一直<记录到最小的。
 * @author zhouh
 * @version 1.0
 * Create by 2022/7/21 9:52
 */
public class 第121买卖股票的最佳时机 {
    public static void main(String[] args) {

    }
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > ans) {   // 可以少遍历一些，去掉无用的循环
                ans = prices[i] - minPrice;
            }
        }
        return ans;
    }
}
