class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            currSum = Math.max(nums[index], currSum + nums[index]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}