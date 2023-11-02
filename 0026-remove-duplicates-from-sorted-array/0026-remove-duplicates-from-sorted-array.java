class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[index] != nums[j]) {
                index++;
                nums[index] = nums[j];
            }
        }
        
        return index + 1;
    }
}