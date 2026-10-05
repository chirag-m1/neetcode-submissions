class Solution {
    void dfs(int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 20) {
                continue;
            }

            int num = nums[i];
            nums[i] = 20;

            temp.add(num);
            dfs(nums, temp, result);
            temp.remove(temp.size() - 1);
            nums[i] = num;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result);
        return result;
    }
}
