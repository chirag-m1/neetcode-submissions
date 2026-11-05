class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        for(int i = n; i >= 0; i--) {
            if(!list.get(i).isEmpty()) {
                for(int num : list.get(i)) {
                    result[--k] = num;
                    if(k == 0) {
                        return result;
                    }
                }   
            }
        }
        return result;
    }
}
