class Solution {
    int dfs(int i, int[] prices, boolean canBuy, int[][] dp) {
        if(i >= prices.length) {
            return 0;
        }
        int buy = canBuy ? 0 : 1;
        if(dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int result = 0;

        if(canBuy) {
            result = Math.max(-prices[i] + dfs(i+1, prices, false, dp), dfs(i+1, prices, true, dp));
        }
        else {
            result = Math.max(dfs(i+1, prices, false, dp), prices[i] + dfs(i+2, prices, !canBuy, dp));
        }
        return dp[i][buy] = result;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(0, prices, true, dp);
    }
}
