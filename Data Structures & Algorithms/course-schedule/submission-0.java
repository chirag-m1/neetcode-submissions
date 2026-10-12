class Solution {
    boolean dfs(int i, int[] visited, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        if(pathVis[i] == 1) {
            return true;
        }

        if(visited[i] == 1) {
            return false;
        }
        
        visited[i] = 1;
        pathVis[i] = 1;

        for(int nei : adj.get(i)) {
            if(dfs(nei, visited, pathVis, adj)) {
                return true;
            }
        }
        pathVis[i] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }

        int v = adj.size();
        int[] visited = new int[v];
        int[] pathVis = new int[v];

        for(int i = 0; i < v; i++) {
            if(visited[i] == 0) {
                if(dfs(i, visited, pathVis, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
