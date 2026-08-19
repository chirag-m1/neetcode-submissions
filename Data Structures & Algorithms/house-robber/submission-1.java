class Solution {
    int f(int i, int[] nums, int[] dp) { 
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];

        int take = nums[i] + f(i+2, nums, dp);
        int notTake = f(i+1, nums, dp);
        return dp[i] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int dp[] =  new int[nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums, dp);
    }
}
