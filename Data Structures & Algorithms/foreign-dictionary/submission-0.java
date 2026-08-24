class Solution {
    boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int visited[]) {
        if(visited[i] == 1) return false;
        if(visited[i] == 2) return true;

        visited[i] = 1;

        for(int next : adj.get(i)) {
            if(!dfs(next, adj, st, visited)) {
                return false;
            }
        }

        visited[i] = 2;
        st.push(i);

        return true;
    }
    public String foreignDictionary(String[] words) {
        int n = words.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            adj.add(new ArrayList<Integer>());
        }

        boolean present[] = new boolean[26];
        for(String word : words) {
            for(char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for(int i = 0; i < n-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLen = Math.min(word1.length(), word2.length());
            for(int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        int visited[] = new int[26];
        for(int i = 0; i < 26; i++) {
            if(present[i] && visited[i] == 0) {
                if(!dfs(i, adj, st, visited)) {
                    return "";
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append((char)(st.pop() + 'a'));
        }
        return sb.toString();
    }
}
