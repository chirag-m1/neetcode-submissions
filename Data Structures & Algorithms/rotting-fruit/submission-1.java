class Pair {
    int i;
    int j;
    int min;
    Pair(int i, int j, int min) {
        this.i = i;
        this.j = j;
        this.min = min;
    }
}
class Solution {
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    boolean isValid(int row, int col, int n, int m) {
        if(row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }
        return true;
    }

    int bfs(int[][] grid, Queue<Pair> q, int[][] visited, int n, int m) {
        int minTime = 0;
        while(!q.isEmpty()) {
            Pair p = q.peek();
            int row = p.i;
            int col = p.j;
            int min = p.min;
            minTime = Math.max(minTime, min);
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nRow =  row + directions[i][0];
                int nCol = col + directions[i][1];
                if(isValid(nRow, nCol, n, m) && visited[nRow][nCol] != 2 
                        && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = 2;
                    q.add(new Pair(nRow, nCol, min + 1));
                }
            }
        }
        return minTime;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
            }
        }
        int result = bfs(grid, q, visited, n, m);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && visited[i][j] != 2) {
                    result = -1;
                }
            }
        }
        return result;
    }
}
