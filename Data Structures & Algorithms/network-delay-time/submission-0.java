class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        q.offer(new int[]{k, 0});
        
        while(!q.isEmpty()) {
            int[] pair = q.poll();
            int src = pair[0];
            int dt = pair[1];
            for(int[] nei : adj.get(src)) {
                if(nei[1] + dt < dist[nei[0]]) {
                    dist[nei[0]] = nei[1] + dt;
                    q.offer(new int[]{nei[0], dist[nei[0]]});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
