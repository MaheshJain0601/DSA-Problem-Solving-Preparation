class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currSum = nums[0], maxSum = nums[0];
        
        for (int index = 1; index < nums.length; ++index) {
            currSum = Math.max(nums[index], currSum + nums[index]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}