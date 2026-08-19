class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n-1]) return nums[0];

        int low = 0, high = n-1;
        int minElem = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[mid]) {
                minElem = Math.min(minElem, nums[low]);
                low = mid + 1;
            }
            else {
                minElem = Math.min(minElem, nums[mid]);
                high = mid - 1;
            }
        }
        return minElem;
    }
}
