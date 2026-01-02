class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int N = nums.length;
        int low = 1, high = N - 2;
        int mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            // Peak element
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            // Check whether the element exists on left half or right half
            // Eliminate appropriately
            if (nums[mid] > nums[mid-1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
        
    }
}