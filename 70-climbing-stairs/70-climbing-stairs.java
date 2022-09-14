class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        
        if (n == 1) {
            return first;
        }
        
        for (int steps = 3; steps <= n; ++steps) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}