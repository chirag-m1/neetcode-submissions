class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minBuy = prices[0];
        for(int i = 1; i < n; i++) {
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
            if(prices[i] < minBuy) {
                minBuy = prices[i];
            }
        }
        return maxProfit;
    }
}
