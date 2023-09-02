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
    private int lower_bound(int[] nums, int target) {
        int answer = -1;
        int low = 0, high = nums.length - 1, mid;
        
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] == target) {
                answer = mid;
            }
            
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;   
    }
    
    private int upper_bound(int[] nums, int target) {
        int answer = -1;
        int low = 0, high = nums.length - 1, mid;
        
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] == target) {
                answer = mid;
            }
            
            if (target >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        int firstPosition = lower_bound(nums, target);
        answer[0] = firstPosition;
        if (firstPosition == -1) {
            answer[1] = -1;
        } else {
            int secondPosition = upper_bound(nums, target);
            answer[1] = secondPosition;
        }
        return answer;
    }
}