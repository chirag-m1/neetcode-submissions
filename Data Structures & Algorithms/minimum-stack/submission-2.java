class MinStack {
    private Deque<Long> st;
    private long mini;
    public MinStack() {
        st = new ArrayDeque<>();
        mini = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            mini = val;
            st.push((long)val);
        }
        else {
            if(val > mini) {
                st.push((long)val);
            }
            else {
                st.push((long)2 * val - mini);
                mini = val;
            }
        }
    }
    
    public void pop() {
        long x = st.pop();
        if(x < mini) {
            mini = 2 * mini - x;
        }
    }
    
    public int top() {
        long x = st.peek();
        if(x < mini) {
            return (int)mini;
        }
        return (int)x;
    }
    
    public int getMin() {
        return (int)mini;
    }
}
