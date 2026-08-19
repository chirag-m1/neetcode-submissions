class Solution {
    int minCost(int i, int[] cost, int[] dp) {
        if(i >= cost.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int oneStep = cost[i] + minCost(i + 1, cost, dp);
        int twoStep = cost[i] + minCost(i + 2, cost, dp);
        return dp[i] = Math.min(oneStep, twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return Math.min(minCost(0, cost, dp), minCost(1, cost, dp));
    }
}
