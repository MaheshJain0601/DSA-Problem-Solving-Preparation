class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        int count = 0;
        
        int left = 0, right = 0, totalOdds = 0;
        
        while (right < nums.length) {
            totalOdds += nums[right]%2;
            
            while (left <= right && totalOdds > k) {
                totalOdds -= nums[left]%2;
                left++;
            }
          
            count += (right - left + 1);
            
            right++;
        }
        
        return count;
    }
}