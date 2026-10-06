class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir : directions) {
                    int nr = dir[0] + cur[0];
                    int nc = dir[1] + cur[1];
                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length
                    || grid[nr][nc] != Integer.MAX_VALUE) {
                        continue;
                    }
                    grid[nr][nc] = count+1;
                    q.offer(new int[]{nr, nc});
                }
            }
            count++;
        }
    }
}
