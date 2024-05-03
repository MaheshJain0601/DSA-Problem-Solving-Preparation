class Solution {
    // Sorting + Two pointer
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        
        while (leftIdx < rightIdx) {
            if (-nums[leftIdx] == nums[rightIdx]) {
                return nums[rightIdx];
            } else if (-nums[leftIdx] < nums[rightIdx]) {
                rightIdx--;
            } else {
                leftIdx++;
            }
        }
        
        return -1;
    }
}