class Solution {
    int dp[][];
    int f(int i, int j, String word1, String word2) {
        if(j < 0) {
            return i + 1;
        }
        if(i < 0) {
            return j + 1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = f(i-1, j-1, word1, word2);
        }
        else {
            int delete = 1 + f(i-1, j, word1, word2);
            int replace = 1 + f(i-1, j-1, word1, word2);
            int insert = 1 + f(i, j-1, word1, word2);
            return dp[i][j] = Math.min(insert, Math.min(replace, delete));
        }
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(word1.length() - 1, word2.length() - 1, word1, word2);
    }
}
