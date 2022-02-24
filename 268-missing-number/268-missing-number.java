class Solution {
    public int missingNumber(int[] nums) {
        int missing = 0;
        int index;
        for (index = 0; index < nums.length; ++index) {
            missing = missing ^ nums[index] ^ index;
        }
        return missing ^ index;
    }
}