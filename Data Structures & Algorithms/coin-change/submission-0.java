class Solution {
    int dfs(int i, int[] coins, int amount, int[][] dp) {
        if(i == coins.length) {
            return amount == 0 ? 0 : (int)(1e9);
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = (int)(1e9);
        if(amount >= coins[i]) {
            take = 1 + dfs(i, coins, amount - coins[i], dp); 
        }
        int notTake = dfs(i+1, coins, amount, dp);
        return dp[i][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= amount; j++)
                dp[i][j] = -1;
        }
        int noOfCoins = dfs(0, coins, amount, dp);
        if(noOfCoins == (int)(1e9)) {
            return -1;
        }
        return noOfCoins;
    }
}
