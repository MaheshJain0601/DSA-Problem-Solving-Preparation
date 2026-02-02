class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
        int countZeroes = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                countZeroes++;
            }

            while (countZeroes > k) {
                if (left <= right && nums[left] == 0) {
                    countZeroes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}