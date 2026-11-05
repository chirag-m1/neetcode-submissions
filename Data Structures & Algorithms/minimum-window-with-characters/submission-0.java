class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int m = t.length();

        for(int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0; 
        int r = 0;
        int startIndex = -1;
        int count = 0;
        while(r < n) {
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0) {
                count++;
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

            while(count == m) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                if(map.get(s.charAt(l)) > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
