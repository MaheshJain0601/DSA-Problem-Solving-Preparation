class Solution {
    // TC: O(log n)
    public double myPow(double x, int n) {
        double answer = 1.0;
        
        long nn = n;
        if (n < 0) {
            nn = (-1) * (nn);
        }
        
        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                answer = answer * x;
                nn = nn - 1;
            }
        }
        
        if (n < 0) {
            answer = (double)(1.0) / (double)answer;
        }
        
        return answer;
    }
}