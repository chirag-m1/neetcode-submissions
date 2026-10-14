class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
       minHeap = new PriorityQueue<>();
       maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a)); 
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.offer(num);
        }
        else {
            if(num > maxHeap.peek()) {
                minHeap.offer(num);
            }
            else {
                maxHeap.offer(num);
            }
        }
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else {
            return maxHeap.peek();
        }
    }
}
