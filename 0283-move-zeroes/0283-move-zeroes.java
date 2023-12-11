class Solution {
    public void moveZeroes(int[] nums) {
        int snowBall = 0;
        int temp;
        
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                snowBall++;
            } else if (snowBall > 0) {
                temp = nums[index];
                nums[index] = 0;
                nums[index-snowBall] = temp;
            }
        }
        
    }
}