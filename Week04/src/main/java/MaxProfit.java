/**
 * @author： chenr
 * @date： Created on 2020/7/5 16:00
 * @version： v1.0
 * @modified By:
 * 买卖股票的最佳时机 II
 */
public class MaxProfit {
    public static void main(String[] args) {
       int [] prices = {7,6,4,3,1};
        System.out.println(
        new MaxProfit().maxProfit(prices)
        );
    }
    public int maxProfit(int[] prices) {

        int profit = 0;
        if (prices == null || prices.length == 0) {
            return profit;
        }
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                profit += prices[i+1] - prices[i];

            }
        }
        return profit;
    }
}
