class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int pse = -1;
        int nse = n;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int ind = st.peek();
                st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[ind] * (nse - pse - 1));
            }
            st.push(i);
        }     
        while(!st.isEmpty()) {
            int ind = st.pop();
            nse = n;
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[ind] * (nse - pse - 1));
        }
        return maxArea;
    }
}
