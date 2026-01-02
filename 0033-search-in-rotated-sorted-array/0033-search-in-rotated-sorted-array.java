class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int low = 0, high = N - 1;
        int mid;
        int result = -1;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            }

            // Identify which half is sorted
            if (nums[low] <= nums[mid]) { // Left half is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right half is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}