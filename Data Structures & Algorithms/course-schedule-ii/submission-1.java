class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }        
        int[] ans = new int[numCourses];
        int i = numCourses-1;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans[i--] = node;

            for(int nei : adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        return i >= 0 ? new int[0] : ans;
    }
}
