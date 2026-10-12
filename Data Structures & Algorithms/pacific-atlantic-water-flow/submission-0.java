class Solution {
    void dfs(int i, int  j, int[][] heights, boolean[][] visited, int prevHeight, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == true
        || prevHeight > heights[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i-1, j, heights, visited, heights[i][j], m, n);
        dfs(i, j-1, heights, visited, heights[i][j], m, n);
        dfs(i+1, j, heights, visited, heights[i][j], m, n);
        dfs(i, j+1, heights, visited, heights[i][j], m, n);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int c = 0; c < n; c++) {
            dfs(0, c, heights, pacific, heights[0][c], m, n);
            dfs(m-1, c, heights, atlantic, heights[m-1][c], m, n);
        }

        for(int r = 0; r < m; r++) {
            dfs(r, 0, heights, pacific, heights[r][0], m, n);
            dfs(r, n-1, heights, atlantic, heights[r][n-1], m, n);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }
        return ans;
    }
}
