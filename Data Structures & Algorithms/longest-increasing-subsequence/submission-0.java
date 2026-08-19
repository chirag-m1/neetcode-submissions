class Solution {
    int lis(int i, int j, int n, int[] nums, int[][] dp) {
        if(i == n) return 0;
        if(dp[i+1][j+1] != -1) {
            return dp[i+1][j+1];
        }
        int include = 0;
        if(j == -1 || nums[i] > nums[j]) {
            include = 1 + lis(i+1, i, n, nums, dp);
        }
        int exclude = lis(i+1, j, n, nums, dp);
        return dp[i+1][j+1] = Math.max(include, exclude);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lis(0, -1, n, nums, dp);
    }
}
