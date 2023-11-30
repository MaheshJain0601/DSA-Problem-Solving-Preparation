class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        
        int maxLength = 0;
        int count = 0;
        
        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] == 0) {
                maxLength = Math.max(maxLength, count);
                count = 0;
                continue;
            } 
            
            count++;
        }
        
        maxLength = Math.max(maxLength, count);
        
        return maxLength; 
    }
}