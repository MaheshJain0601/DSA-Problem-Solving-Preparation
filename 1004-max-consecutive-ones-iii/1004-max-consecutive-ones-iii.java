class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        
        int maxLength = 0, zeroesCount = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroesCount++;
            }
            
            while (zeroesCount > k && left <= right) {
                if (nums[left] == 0) {
                    zeroesCount--;  
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;   
    }
}