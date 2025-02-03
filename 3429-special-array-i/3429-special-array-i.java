class Solution {
    // Approch 1:
    // TC: O(N)
    // SC: O(1)
    public boolean isArraySpecial(int[] nums) {
        for (int index = 0; index < nums.length - 1; ++index) {
            if (nums[index]%2 == nums[index+1]%2) {
                return false;
            }
        }
        return true;
    }
}