class Solution {
    boolean isPalindrome(String s, int i, int e) {
        while(i < e) {
            if(s.charAt(i) != s.charAt(e)) {
                return false;
            }
            i++;
            e--;
        }
        return true;
    }

    void dfs(int index, String s, List<String> list, List<List<String>> lists) {
        if(index == s.length()) {
            lists.add(new ArrayList<>(list));
        }
        for(int i = index; i < s.length(); ++i) {
            if(isPalindrome(s, index, i)) {
                list.add(s.substring(index, i+1));
                dfs(i+1, s, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, lists);
        return lists;
    }
}
