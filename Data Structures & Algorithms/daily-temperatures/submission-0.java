class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();

        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.poll();
            }
            if(st.isEmpty()) {
                result[i] = 0;
            }
            else {
                result[i] = st.peek() - i;
            }
            st.push(i);
        }
        return result;
    }
}
