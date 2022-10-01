import java.util.Arrays;

class Solution {
    // 1. Recursive solution
    private int recursiveRob(int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        
        int robbed = nums[index] + recursiveRob(nums, index - 2);
        int notRobbed = 0 + recursiveRob(nums, index - 1);
        return Math.max(robbed, notRobbed);
    }
    
    // 2. Memoization Rob using DP
    private int recursiveRobMemoize(int[] nums, int index, int[] dp) {
        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        int robbed = nums[index] + recursiveRob(nums, index - 2);
        int notRobbed = 0 + recursiveRob(nums, index - 1);
        dp[index] = Math.max(robbed, notRobbed);
        return dp[index];
    }
    
    // 3. Iterative Tabulation in DP
    private int iterativeTabRob(int[] nums, int length) {
        int[] dp = new int[length];
        dp[0] = nums[0];
        
        
        for (int index = 1; index < length; index++) {
            int take = nums[index];
            if (index > 1) {
                take += dp[index-2];
            }
            int notTake = 0 + dp[index-1];
            dp[index] = Math.max(take, notTake);
        }
        return dp[length - 1];
        
    }
    
    // 4. Iterative without extra space in DP
    private int iterativeWithOutSpaceRob(int[] nums, int length) {
        int prev;
        int prev2 = 0;
        
        prev = nums[0];
        
        for (int index = 1; index < length; index++) {
            int take = nums[index];
            if (index > 1) {
                take += prev2;
            }
            int notTake = 0 + prev;
            int curr = Math.max(take, notTake);
            
            prev2 = prev;
            prev = curr;
        }
        return prev;
        
    }
    public int rob(int[] nums) {
        // 1. Recursive Rob
        // return recursiveRob(nums, nums.length - 1);
        
        // 2. Memoization Rob using DP
        //int[] dp = new int[nums.length + 1];
        //Arrays.fill(dp, -1);
        //return recursiveRobMemoize(nums, nums.length - 1, dp);
        
        // 3. Iterative Tabulation in DP
        //return iterativeTabRob(nums, nums.length);
        
        // 4. Iterative without extra space in DP
        return iterativeWithOutSpaceRob(nums, nums.length);
    }
}