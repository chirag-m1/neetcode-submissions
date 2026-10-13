class Solution {
    int dfs(int i, int j, int[][] matrix, int prevElem, int[][] dp) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
        || prevElem >= matrix[i][j]) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        } 
        int up = dfs(i-1, j, matrix, matrix[i][j], dp);
        int down = dfs(i+1, j, matrix, matrix[i][j], dp);
        int right = dfs(i, j+1, matrix, matrix[i][j], dp);
        int left = dfs(i, j-1, matrix, matrix[i][j], dp);
        return dp[i][j] = 1 + Math.max(up, Math.max(down, Math.max(right, left)));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        int maxi = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxi = Math.max(maxi, dfs(i, j, matrix, -1, dp));
            }
        }
        return maxi;
    }
}
