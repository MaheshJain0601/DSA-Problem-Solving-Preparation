class Solution {
    private int longIncreaseSubseqRecursive(int[] nums, int[][] dp, int currIndex, int prevIndex) {
        if (currIndex >= nums.length) {
            return 0;
        }
        
        if (prevIndex != -1 && dp[currIndex][prevIndex] != -1) {
            return dp[currIndex][prevIndex];
        }
        
        int takeElement = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            takeElement = 1 + longIncreaseSubseqRecursive(nums, dp, currIndex + 1, currIndex);
        }
        int skipElement = 0 + longIncreaseSubseqRecursive(nums, dp, currIndex + 1, prevIndex);
        
        if (prevIndex != -1) {
            dp[currIndex][prevIndex] = Math.max(takeElement, skipElement);    
        }
        
        return Math.max(takeElement, skipElement);
    }
    
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] temp: dp) {
            Arrays.fill(temp, -1);    
        }

        return longIncreaseSubseqRecursive(nums, dp, 0, -1);
    }
}