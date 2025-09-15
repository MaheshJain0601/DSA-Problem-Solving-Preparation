class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;
        int low = 0, high = N - 1;
        int mid, minValue = Integer.MAX_VALUE;

        while (low <= high) {
            mid = low + (high - low)/2;
            // search space is already sorted
            // then always arr[low] will be smaller
            // in that search space
            if (nums[low] <= nums[high]) {
                minValue = Math.min(minValue, nums[low]);
                break;
            }
            // left space is sorted
            if (nums[low] <= nums[mid]) {
                minValue = Math.min(minValue, nums[low]);
                low = mid + 1;
            } else { // right space is sorted
                minValue = Math.min(minValue, nums[mid]);
                high = mid - 1;
            }
        }
        return minValue;
    }
}