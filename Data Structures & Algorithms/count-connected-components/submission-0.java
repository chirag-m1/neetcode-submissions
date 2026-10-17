class Solution {
    void dfs(int i, int n, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if(i >= n) {
            return;
        }
        visited[i] = true;
        for(int nei : adj.get(i)) {
            if(!visited[nei]) {
                dfs(nei, n, adj, visited);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, adj, visited);
                count++;
            }
        }
        return count;
    }
}
