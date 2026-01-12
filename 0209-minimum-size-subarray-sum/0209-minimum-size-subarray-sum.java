class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        } 
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        int currSum = 0;
        while (i <= j && j < nums.length) {
            currSum += nums[j];
            while(currSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}