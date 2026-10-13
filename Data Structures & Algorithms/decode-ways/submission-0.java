class Solution {
    int dfs(int i, String s, int[] dp) {
        if(i == s.length()) {
            return 1;
        }
        if(s.charAt(i) == '0') {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int ways = dfs(i+1, s, dp);
        if(i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num <= 26) {
                ways = ways + dfs(i+2, s, dp);
            }
        }
        return dp[i] = ways;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return dfs(0, s, dp);
    }
}
