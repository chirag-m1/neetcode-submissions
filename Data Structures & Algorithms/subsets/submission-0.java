class Solution {
    void find(int i, int[] nums, List<Integer> sub, List<List<Integer>> subsets) {
        if(i == nums.length) {
            subsets.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        find(i+1, nums, sub, subsets);
        sub.remove(sub.size() - 1);
        find(i+1, nums, sub, subsets);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        find(0, nums, sub, subsets);
        return subsets;
    }
}
