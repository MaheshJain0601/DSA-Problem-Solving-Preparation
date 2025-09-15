class Solution {
    public boolean search(int[] nums, int target) {
        int N = nums.length;
        int low = 0, high = N - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return true;
            }
            // Trimming duplicate space
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            
            // left space is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right space is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}