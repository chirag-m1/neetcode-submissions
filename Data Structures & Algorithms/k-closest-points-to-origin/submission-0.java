class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        for(int i = 0; i < points.length; i++) {
            pq.offer(new int[]{i, (points[i][0] * points[i][0]) + (points[i][1] * points[i][1])});
        }
        int[][] ans = new int[k][2];
        while(!pq.isEmpty() && k > 0) {
            int[] curr = pq.poll();
            int index = curr[0];
            ans[k-1][0] = points[index][0];
            ans[k-1][1] = points[index][1];
            k--;
        }
        return ans;
    }
}
