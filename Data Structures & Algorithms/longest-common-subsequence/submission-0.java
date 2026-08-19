class Solution {
    int lcs(int i, int j ,int n, int m, String text1, String text2, int[][] dp) {
        if(i == n || j == m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i+1, j+1, n, m, text1, text2, dp);
        }
        return dp[i][j] = Math.max(lcs(i+1, j, n, m, text1, text2, dp), 
                                    lcs(i, j+1, n, m, text1, text2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcs(0, 0, n, m , text1, text2, dp);
    }
}
