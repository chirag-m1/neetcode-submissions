class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    void dfs(int idx, int[] nums, List<Integer> sub) {
        result.add(new ArrayList<>(sub));
        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            sub.add(nums[i]);
            dfs(i+1, nums, sub);
            sub.remove(sub.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.clear();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return result;
    }
}