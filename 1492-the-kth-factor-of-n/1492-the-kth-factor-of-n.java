class Solution {
    public int kthFactor(int n, int k) {
        int squareRoot = (int)Math.sqrt(n);
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        
        for (int i = squareRoot; i >= 1; i--) {
            if (n % (n/i) == 0) {
                k--;
                if (k == 0) {
                    return n / i;
                }
            }
        }
        
        return -1;
        
    }
}