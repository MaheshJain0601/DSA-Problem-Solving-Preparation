All Possible ways:
We start at either step 0 or step 1. The target is to reach either last or second last step, whichever is minimum.
​
Step 1 - Identify a recurrence relation between subproblems. In this problem,
Recurrence Relation:
mincost(i) = cost[i]+min(mincost(i-1), mincost(i-2))
Base cases:
mincost(0) = cost[0]
mincost(1) = cost[1]
​
Step 2 - Covert the recurrence relation to recursion
​
// Recursive Top Down - O(2^n) Time Limit Exceeded
public int minCostClimbingStairs(int[] cost) {
int n = cost.length;
return Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
private int minCost(int[] cost, int n) {
if (n < 0) return 0;
if (n==0 || n==1) return cost[n];
return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
Step 3 - Optimization 1 - Top Down DP - Add memoization to recursion - From exponential to linear.
​
// Top Down Memoization - O(n) 1ms
int[] dp;
public int minCostClimbingStairs(int[] cost) {
int n = cost.length;
dp = new int[n];
return Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
private int minCost(int[] cost, int n) {
if (n < 0) return 0;
if (n==0 || n==1) return cost[n];
if (dp[n] != 0) return dp[n];
dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
return dp[n];
}
Step 4 - Optimization 2 -Bottom Up DP - Convert recursion to iteration - Getting rid of recursive stack
​
// Bottom up tabulation - O(n) 1ms
public int minCostClimbingStairs(int[] cost) {
int n = cost.length;
int[] dp = new int[n];
for (int i=0; i<n; i++) {