class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int i = 0, j = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        
        while (j < nums.length) {
            sum += nums[j];
            while (i < nums.length && sum >= target) {
                minSize = Math.min(minSize, j - i + 1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        
        return (minSize == Integer.MAX_VALUE) ? 0:  minSize;
    }
}