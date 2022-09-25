class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int previous_last = cost[0];
        int previous = cost[1];
        if (N > 2) {
            int curr;
            for (int index = 2; index < N; ++index) {
                curr = cost[index] + Math.min(previous, previous_last);
                previous_last = previous;
                previous = curr;
            }
        }
        
        return Math.min(previous, previous_last);
        
    }
}