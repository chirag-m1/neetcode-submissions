class Solution {
    int dfs(int i, int j, int m, int n, int[][] grid) {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(i + 1, j, m, n, grid) + dfs(i - 1, j, m, n, grid) +
        dfs(i, j - 1, m, n, grid) + dfs(i, j + 1, m, n, grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int count = dfs(i, j, m, n, grid);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }
}
