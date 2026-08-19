class Solution {
    void dfs(int i, int j, char[][] grid, int[][] dp, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m) {
            if(dp[i][j] == 1) return;
            dp[i][j] = 1;   
            if(grid[i][j] == '1') {
                dfs(i-1, j, grid, dp, n, m);
                dfs(i+1, j, grid, dp, n, m);
                dfs(i, j-1, grid, dp, n, m);
                dfs(i, j+1, grid, dp, n, m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && dp[i][j] != 1) {
                    count++;
                    dfs(i, j, grid, dp, n, m);
                }
            }
        }
        return count;
    }
}
