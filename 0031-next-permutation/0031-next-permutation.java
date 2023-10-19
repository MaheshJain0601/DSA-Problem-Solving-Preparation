class Solution {
    private void swap(int[] nums, int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex < 0) {
            return;
        }
        if (fromIndex >= nums.length || toIndex >= nums.length) {
            return;
        }
        
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start++, end--);
        }
    }
    
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int firstIndex = nums.length - 2;
        while (firstIndex >= 0 && nums[firstIndex] >= nums[firstIndex + 1]) {
            firstIndex--;
        }
        
        if (firstIndex >= 0) {
            int secondIndex = nums.length - 1;
            while (nums[secondIndex] <= nums[firstIndex]) {
                secondIndex--;
            }
            swap(nums, firstIndex, secondIndex);
        }
        reverse(nums, firstIndex + 1, nums.length - 1);
    }
}