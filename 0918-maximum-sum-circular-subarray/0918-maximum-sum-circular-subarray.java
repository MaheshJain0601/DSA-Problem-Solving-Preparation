class Solution {
    private int maximumSubarraySum(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int index = 1; index < nums.length; ++index) {
            currSum = Math.max(currSum + nums[index], nums[index]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    
    private int minimumSubarraySum(int[] nums) {
        int currSum = nums[0];
        int minSum = nums[0];
        for (int index = 1; index < nums.length; ++index) {
            currSum = Math.min(currSum + nums[index], nums[index]);
            minSum = Math.min(minSum, currSum);
        }
        return minSum;
    }
    
    private int arraySum(int[] nums) {
        int sum = 0;
        for (int index = 0; index < nums.length; ++index) {
            sum += nums[index];
        }
        return sum;
    }
    
    public int maxSubarraySumCircular(int[] nums) {
        int maxSumNonCircular = maximumSubarraySum(nums);
        int totalArraySum = arraySum(nums);
        int maxSumCircular = totalArraySum - minimumSubarraySum(nums);
        
        if (maxSumNonCircular > 0) {
             return Math.max(maxSumNonCircular, maxSumCircular);
        }
        
        return maxSumNonCircular;
       
    }
}