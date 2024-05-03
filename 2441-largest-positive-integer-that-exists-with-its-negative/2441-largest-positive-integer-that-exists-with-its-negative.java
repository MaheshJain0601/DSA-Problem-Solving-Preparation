class Solution {
    
    public int findMaxK(int[] nums) {
        int[] lookup = new int[1000 - (-1000) + 1];
        
        int result = -1;
        int idx;
        
        for (int num: nums) {
            idx = (-1 * num) + 1000;
            if (lookup[idx] == 1) {
                result = Math.max(result, Math.abs(num));
            }
            lookup[num + 1000] = 1;
        }
        
        return result;
    }
    
    // Sorting + Two pointer
    public int findMaxKSorting(int[] nums) {
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