class Solution {
    int f(int i, int j, int[] nums, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int maxi = 0;
        for(int k = i; k <= j; k++) {
            int coins = nums[i-1] * nums[k] * nums[j+1] 
                        + f(i, k -1, nums, dp) + f(k+1, j, nums, dp);
            maxi = Math.max(maxi, coins);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = temp[n+1] = 1;
        for(int i = 0; i < n; i++) {
            temp[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for(int i = 0; i < n+2; i++) {
            for(int j = 0; j < n+2; j++) {
                dp[i][j] = -1;
            }
        }
        return f(1, n, temp, dp);
    }
}
