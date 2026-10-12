class Solution {
    int dfs(int i, int amount, int[] coins, int[][] dp) {
        if(i >= coins.length) {
            return 0;
        }

        if(amount == 0) return 1;

        if(dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int notTake = dfs(i+1, amount, coins, dp);
        int take = 0;
        if(coins[i] <= amount) {
            take = dfs(i, amount-coins[i], coins, dp);
        }
        return dp[i][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, amount, coins, dp);
    }
}
