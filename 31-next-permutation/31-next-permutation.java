class Solution {
    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int firstIndex = nums.length - 2;
        while (firstIndex >= 0 && nums[firstIndex] >= nums[firstIndex+1])
            firstIndex--;
        if (firstIndex >= 0) {
            int secondIndex = nums.length - 1;
            while (nums[secondIndex] <= nums[firstIndex]) 
                secondIndex--;
            swap(nums, firstIndex, secondIndex);
        }
        reverse(nums, firstIndex + 1, nums.length - 1);
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }
}