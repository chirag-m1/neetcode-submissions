class Solution {
    int f(int i, int[] nums, int target, int currSum, int[][] dp) {
        if(i == nums.length) {
            return currSum == target ? 1 : 0;
        }
        if(currSum > target) {
            return 0;
        }

        if(dp[i][currSum] != -1) return dp[i][currSum];

        int take = f(i+1, nums, target, currSum + nums[i], dp);
        int notTake = f(i+1, nums, target, currSum, dp);
        return dp[i][currSum] = take + notTake;
    }
    int countPartitions(int n, int target, int[] nums) {
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, nums, target, 0, dp);
    }
    public int findTargetSumWays(int[] nums, int target) {
            // s1 - s2 = target
            // totSum - s2 - s2 = target;
            // s2 = (totSum - target) / 2;

        int n = nums.length;
        int totSum = 0;
        for(int i = 0; i < n; i++) {
            totSum += nums[i];
        }
        if(Math.abs(target) > totSum || (totSum - target) % 2 != 0) return 0;
        int sub1 = (totSum - target) / 2;
        return countPartitions(nums.length, sub1, nums);
    }
}
