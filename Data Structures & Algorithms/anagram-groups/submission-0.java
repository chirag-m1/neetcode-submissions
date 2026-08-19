class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> charList = new ArrayList<>(26);
            for(int j = 0; j < 26; j++) {
                charList.add(0);
            }
            String s = strs[i];
            for(char c : s.toCharArray()) {
                charList.set(c - 'a', charList.get(c - 'a') + 1);
            }
            if(map.containsKey(charList)) {
                map.get(charList).add(s);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(charList, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> ls : map.values()) {
            ans.add(ls);
        }
        return ans;
    }
}
