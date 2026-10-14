class Solution {

    void dfs(int i, String digits, StringBuilder curr, List<String> result, Map<Integer, String[]> map)     {

        if(i == digits.length()) {
            result.add(curr.toString()) ;
            return;
        }

        int digit = digits.charAt(i) - '0';

        for(String s : map.get(digit)) {
            curr.append(s);
            dfs(i+1, digits, curr, result, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    void digitLetterMapping(Map<Integer, String[]> map) {
        map.put(2, new String[] {"a", "b", "c"});
        map.put(3, new String[] {"d", "e", "f"});
        map.put(4, new String[] {"g", "h", "i"});
        map.put(5, new String[] {"j", "k", "l"});
        map.put(6, new String[] {"m", "n", "o"});
        map.put(7, new String[] {"p", "q", "r", "s"});
        map.put(8, new String[] {"t", "u", "v"});
        map.put(9, new String[] {"w", "x", "y", "z"});
    }
    public List<String> letterCombinations(String digits) {
        Map<Integer, String[]> map = new HashMap<>();
        digitLetterMapping(map);
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) {
            return result;
        }

        dfs(0, digits, new StringBuilder(), result, map);

        return result;
    }
}
