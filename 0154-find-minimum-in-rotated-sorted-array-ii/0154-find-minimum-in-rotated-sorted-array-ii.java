class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;
        int low = 0, high = N - 1, mid;
        if (nums[low] < nums[high]) return nums[low];

        while (low <= high) {
            mid = low + (high - low)/2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}