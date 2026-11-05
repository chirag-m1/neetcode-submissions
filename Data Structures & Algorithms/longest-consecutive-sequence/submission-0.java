class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxi = 0;
        for(int num : nums) {
            if(set.contains(num-1)) {
                continue;
            }
            int count = 0;
            while(set.contains(num)) {
                count++;
                num++;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}
