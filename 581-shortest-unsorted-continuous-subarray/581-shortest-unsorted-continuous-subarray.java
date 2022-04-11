import java.lang.Math;
import java.lang.Integer;
class Solution {
    private boolean outOfOrder(int[] nums, int index) {
        if (index == 0) {
            return nums[index] > nums[index+1];
        } else if (index == nums.length - 1) {
            return nums[index] < nums[index-1];
        } else {
            return nums[index] > nums[index+1] || nums[index] < nums[index-1];
        }
    }
    
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; ++index) {
            if (outOfOrder(nums, index)) {
                smallest = Math.min(smallest, nums[index]);
                largest = Math.max(largest, nums[index]);
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            return 0;
        }
        int left = 0;
        //System.out.println(smallest+" "+largest);
        while (smallest >= nums[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (largest <= nums[right]) {
            right--;
        }
        return (right-left+1);
    }
}
