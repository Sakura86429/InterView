package leetcode;

/**
 * Topic
 * Description
 * 1是只能买入一次，卖出一次
 * 2是可以买入很多次，卖出很多次。但是最多时候只能持有一股股票
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/15 11:21
 */
public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
