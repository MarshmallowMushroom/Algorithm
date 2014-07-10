/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;
        //scan from left to right find the max profit before day i
        int [] max = new int [prices.length];
        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max[i] = Math.max(prices[i] - lowest, max[i-1]);
            lowest = Math.min(prices[i], lowest);
            
        }
        //scan from right to left to find the max profit after day i
        int highest = prices[prices.length - 1];
        int max2 = max[prices.length - 1];
        for (int i = prices.length - 2; i > 0; i--) {
            max2 = Math.max(max[i-1] + highest - prices[i], max2);
            highest = Math.max(prices[i], highest);
        }
        return max2;
    }
}
