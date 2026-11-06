class Triplet {
    int height;
    int row;
    int col;
    public Triplet(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Triplet> minHeap = 
        new PriorityQueue<>((a,b) -> Integer.compare(a.height, b.height));

        minHeap.offer(new Triplet(grid[0][0], 0, 0));

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(!minHeap.isEmpty()) {
            Triplet t = minHeap.poll();
            if(visited[t.row][t.col]) {
                continue;
            }
            visited[t.row][t.col] = true;
            if(t.row == n-1 && t.col == n-1) {
                return t.height;
            }

            for(int[] dir : dirs) {
                int rRow = t.row + dir[0];
                int rCol = t.col + dir[1];
                if(rRow < n && rCol < n && rRow >= 0 && rCol >= 0 && !visited[rRow][rCol]) {
                    int maxHeight = Math.max(grid[rRow][rCol], t.height); 
                    minHeap.offer(new Triplet(maxHeight, rRow, rCol));
                }
            }
        }
        return 0;
    }
}
