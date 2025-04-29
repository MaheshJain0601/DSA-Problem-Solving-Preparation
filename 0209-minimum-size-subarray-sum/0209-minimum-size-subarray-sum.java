class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        } 
        int sum = 0;
        int i = 0, j = 0;
        int minimumLength = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];

            while (i <= j && sum >= target) {
                minimumLength = Math.min(minimumLength, j - i + 1);

                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }
}