class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int high = nums.length - 1;
        int low = 0, mid = 0;
        while (mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, high, mid);
                high--;
            }
        }        
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}