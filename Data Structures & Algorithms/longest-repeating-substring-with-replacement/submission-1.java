class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int maxFreq = 0;
        int ans = 0;
        // Map<Character, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        while(r < n) {
            char rc = s.charAt(r);
            // map.put(rc, map.getOrDefault(rc, 0) + 1);
            arr[rc - 'A']++;
            maxFreq = Math.max(maxFreq, arr[rc - 'A']);
            while((r - l + 1) - maxFreq > k) {
                char lc = s.charAt(l);
                // map.put(lc, map.get(lc) - 1);
                arr[lc - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
