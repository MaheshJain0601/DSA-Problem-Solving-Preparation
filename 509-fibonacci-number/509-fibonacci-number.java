class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int last_prev = 0;
        int prev = 1;
        int curr;
        
        for (int index = 2; index <= n; ++index) {
            curr = prev + last_prev;
            last_prev = prev;
            prev = curr;
        }
        
        return prev;
    }
}