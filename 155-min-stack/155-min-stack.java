class MinStack {
    private class Node {
        int value;
        int minimum;
        Node next;
        
        public Node (int value, int minimum, Node next) {
            this.value = value;
            this.minimum = minimum;
            this.next = next;
        }
    }
    
    Node top;
    
    public MinStack() {
        top = null;
    }
    
    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            top = new Node(val, Math.min(val, top.minimum), top);
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.minimum;
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