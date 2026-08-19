class Solution {
    int f(int i, int n, int[] dp) {
        if(i > n) return 0;
        if(i == n) return 1;
        if(dp[i] != -1) return dp[i];
        int way1 = f(i+1, n, dp);
        int way2 = f(i+2, n, dp);
        return dp[i] = way1 + way2;
    }
    public int climbStairs(int n) {
        int dp[] = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return f(0, n, dp);
    }
}
