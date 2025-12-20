class MinStack {

    Stack<Long> st;
    long minVal;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(1L * val);
            minVal = 1L * val;
            return;
        }
        if (val > minVal) {
            st.push(1L*val);
        } else {
            st.push(2L*val - minVal);
            minVal = val;
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        long top = st.pop();
        if (top < minVal) {
            minVal = (2*minVal - top);
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            return -1;
        }
        long top = st.peek();
        if (top > minVal) {
            return (int) top;
        }
        return (int) minVal;
    }
    
    public int getMin() {
        return (int) minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */