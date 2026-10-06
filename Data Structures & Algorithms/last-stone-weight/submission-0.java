class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) ->              Integer.compare(y, x));
        for(int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }

        while(!maxHeap.isEmpty()) {
            if(maxHeap.size() == 0) {
                return 0;
            }
            if(maxHeap.size() == 1) {
                return maxHeap.peek();
            }

            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(Math.abs(x-y) != 0) {
                maxHeap.offer(Math.abs(x-y));
            }
        }
        return 0;
    }
}
