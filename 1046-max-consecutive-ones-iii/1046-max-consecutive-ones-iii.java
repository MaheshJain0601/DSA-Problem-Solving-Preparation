class Solution {
    // O(N)
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int currZeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                currZeros++;
            }
            
            if (currZeros > k) {
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
    // O(2N)
    public int longestOnesShrinking(int[] nums, int k) {
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