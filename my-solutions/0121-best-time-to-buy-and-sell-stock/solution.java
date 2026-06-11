class Solution {
    public int maxProfit(int[] prices) {
        int curPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < curPrice) {
                curPrice = prices[i];
            } else if (maxProfit < prices[i] - curPrice) {
                maxProfit = prices[i] - curPrice;
            }
        }
        return maxProfit;
    }
}
