class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int currZeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                currZeros++;
            }
            
            while (currZeros > k) {
                if (left <= right && nums[left] == 0) {
                    currZeros--;
                }
                left++;
            } 
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}