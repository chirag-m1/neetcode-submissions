class Solution {
    int maxMoney(int i, int n, int[] nums, int[] dp) {
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + maxMoney(i+2, n, nums, dp);
        int notTake = maxMoney(i+1, n, nums, dp);
        return dp[i] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length], dp2 = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }
        return Math.max(maxMoney(1, nums.length - 1, nums, dp1), maxMoney(0, nums.length - 2, nums, dp2));
    }
}
