class Solution {
    public int pivotIndex(int[] nums) {
        
        int rightSum = 0;
        int length = nums.length;
        for (int index = 0; index < length; ++index) {
            rightSum += nums[index];
        }
        
        int leftSum = 0;
        for (int index = 0; index < length; ++index) {
            rightSum -= nums[index];
            if (leftSum == rightSum) {
                return index;
            }
            leftSum += nums[index];   
        }
        return -1;
    }
}