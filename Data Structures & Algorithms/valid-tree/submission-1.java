class Solution {
    class Pair {
        int node;
        int parent;
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    boolean checkCycle(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));
        visited[src] = 1;
        while(!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for(int nei : adj.get(node)) {
                if(visited[nei] == 0) {
                    visited[nei] = 1;
                    q.offer(new Pair(nei, node));
                }
                else if(nei != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] visited = new int[n];

        if(checkCycle(0, adj, visited)) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
