class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        if (nums[low] <= nums[high]) {
            return nums[0];
        }
        while (low <= high) {
            mid = (low + high)/2;
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            } else if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else if (nums[high] >= nums[mid]) {
                high = mid - 1;
            }            
        }
        return -1;        
    }
}