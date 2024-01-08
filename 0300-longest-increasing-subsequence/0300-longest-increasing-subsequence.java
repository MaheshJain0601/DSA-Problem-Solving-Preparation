class Solution {
    private int longIncreaseSubseqRecursiveTopDown(int[] nums, int[][] dp, int currIndex, int prevIndex) {
        if (currIndex >= nums.length) {
            return 0;
        }
        
        if (prevIndex != -1 && dp[currIndex][prevIndex] != -1) {
            return dp[currIndex][prevIndex];
        }
        
        int takeElement = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            takeElement = 1 + longIncreaseSubseqRecursiveTopDown(nums, dp, currIndex + 1, currIndex);
        }
        int skipElement = 0 + longIncreaseSubseqRecursiveTopDown(nums, dp, currIndex + 1, prevIndex);
        
        if (prevIndex != -1) {
            dp[currIndex][prevIndex] = Math.max(takeElement, skipElement);    
        }
        
        return Math.max(takeElement, skipElement);
    }
    
    public int lengthOfLISTopDown(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] temp: dp) {
            Arrays.fill(temp, -1);    
        }

        return longIncreaseSubseqRecursiveTopDown(nums, dp, 0, -1);
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp, 1);
        int maxLIS = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }

        return maxLIS;
    }
}