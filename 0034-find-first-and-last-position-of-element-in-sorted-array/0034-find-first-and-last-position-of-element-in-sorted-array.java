class Solution {
    private int lowerBound(int[] nums, int N, int target) {
        int low = 0, high = N - 1;
        int mid;
        int result = N;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    private int upperBound(int[] nums, int N, int target) {
        int low = 0, high = N - 1;
        int mid;
        int result = N;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int lb = lowerBound(nums, N, target);
        if (lb == N || nums[lb] != target) {
            return new int[]{-1, -1};
        }
        int ub = upperBound(nums, N, target);
        return new int[]{lb, ub - 1};
    }
}