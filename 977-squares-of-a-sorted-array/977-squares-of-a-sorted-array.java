class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        int left = 0, right = nums.length - 1;
        int rIndex = right;
        while (rIndex >= 0) {
            if (nums[right]*nums[right] >= nums[left]*nums[left]) {
                result[rIndex] = nums[right]*nums[right];
                right--;
            } else {
                result[rIndex] = nums[left]*nums[left];
                left++;
            }
            rIndex--;
        }
        return result;
    }
}