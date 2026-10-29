class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        for(int i = 0; i <= k; i++) {
            int[] tmp = Arrays.copyOf(dist, n);
            for(int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                if(dist[u] != (int)(1e9) && dist[u] + price < tmp[v]) {
                    tmp[v] = dist[u] + price;
                }
            }
            dist = tmp;
        }
        return dist[dst] == (int)(1e9) ? -1 : dist[dst];
    }
}
