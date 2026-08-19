class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void comb(int i, int[] nums, int target, int sum, ArrayList<Integer> arr) {
        if(i >= nums.length || sum > target) {
            return;
        }
        if(sum == target) {
            result.add(new ArrayList<Integer>(arr));
            return;
        }
        arr.add(nums[i]);
        comb(i, nums, target, sum + nums[i], arr);
        arr.remove(arr.size() - 1);
        comb(i+1, nums, target, sum, arr);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        comb(0, nums, target, 0, new ArrayList<Integer>());
        return result;
    }
}
