class Solution {
    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0;
        int high = nums.length - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                answer = mid;
                if (isLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            }
        }
        return answer;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = binarySearch(nums, target, true);
        answer[1] = binarySearch(nums, target, false);
        return answer;
    }
}