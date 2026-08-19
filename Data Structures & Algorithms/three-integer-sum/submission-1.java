class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int j = i+1;
            int k = n-1;
            // System.out.println(target);
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    // System.out.println("reached");
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                }
                else if(nums[j] + nums[k] < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return list;
    }
}
