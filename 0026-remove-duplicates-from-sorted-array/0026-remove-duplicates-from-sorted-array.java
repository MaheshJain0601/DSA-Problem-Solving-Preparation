class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] > nums[index-1]) {
                 nums[index] = nums[j];
                 index++;
            }
        }
        
        return index;
    }
}