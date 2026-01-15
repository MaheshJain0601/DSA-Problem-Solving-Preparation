class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minElementIndex = -1;
        int maxElementIndex = -1;
        int culpritIndex = -1, smallestIndex;
        long result = 0;
        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] < minK || nums[index] > maxK) {
                culpritIndex = index;
            }
            if (nums[index] == minK) {
                minElementIndex = index;
            }

            if (nums[index] == maxK) {
                maxElementIndex = index;
            }
            smallestIndex = Math.min(minElementIndex, maxElementIndex);
            int numSubarraysAtIndex = smallestIndex - culpritIndex;
            result += ((numSubarraysAtIndex <= 0) ? 0 : numSubarraysAtIndex);
        }
        return result;
    }
}