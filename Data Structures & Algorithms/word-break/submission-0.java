class Solution {
    boolean match(int ind, String s, List<String> wordDict, int[] dp) {
        if(ind == s.length()) {
            return true;
        }

        if(dp[ind] != -1) {
            return dp[ind] == 1;
        }

        String sub = s.substring(ind);
        for(int i = 0; i < wordDict.size(); i++) {
            String wordToMatch = wordDict.get(i);
            if(sub.startsWith(wordToMatch)) {
                if(match(ind + wordToMatch.length(), s, wordDict, dp)) {
                    dp[ind] = 1;
                    return true;
                }
            }
        }
        dp[ind] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return match(0, s, wordDict, dp);
    }
}
