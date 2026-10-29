class Pair {
    int wt;
    int node;
    public Pair(int wt, int node) {
        this.wt = wt;
        this.node = node;
    }
}

class Solution {
    int findManDist(int[][] points, int p1, int p2) {
        return Math.abs(points[p1][0] - points[p2][0]) + 
        Math.abs(points[p1][1] - points[p2][1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.wt, b.wt));
        boolean[] visited = new boolean[n];
        pq.offer(new Pair(0, 0));

        int minCost = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int wt = p.wt;
            int node = p.node;
            if(visited[node]) continue;
            visited[node] = true;
            minCost = minCost + wt;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    pq.offer(new Pair(findManDist(points, i, node), i));
                }
            }
        }
        return minCost;   
    }
}
