class Solution {
    void dfs(int i, int[] candidates, int target, int sum, List<Integer> comb, List<List<Integer>> result) {
        if(target == sum) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j-1]) {
                continue;
            }
            if(sum + candidates[j] > target) {
                break;
            }
            comb.add(candidates[j]);
            dfs(j+1, candidates, target, sum + candidates[j], comb, result);
            comb.remove(comb.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(candidates);
        dfs(0, candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
}
