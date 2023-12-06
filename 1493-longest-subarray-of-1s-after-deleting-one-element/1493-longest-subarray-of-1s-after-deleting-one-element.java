class Solution {
    public int longestSubarray(int[] nums) {
        
        int left = 0, right = 0, currZeroCount = 0, result = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                currZeroCount++;
            }
            
            while (currZeroCount > 1) {
                if (nums[left] == 0) {
                    currZeroCount--;
                }
                left++;
            }
            
            result = Math.max(result, right - left + 1);
            right++;
        }
        
        return result - 1;
    }
}