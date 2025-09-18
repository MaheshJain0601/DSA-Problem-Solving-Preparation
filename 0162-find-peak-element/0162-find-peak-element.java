class Solution {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }
        // Corner cases
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[N-1] > nums[N-2]) {
            return N-1;
        }

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