class Solution {
    public boolean canJump(int[] nums) {
        int reachableIndex = 0;
        
        for (int index = 0; index < nums.length; ++index) {
            if (reachableIndex < index) {
                return false;
            }
            reachableIndex = Math.max(reachableIndex, index + nums[index]);
        }
        
        return true;
    }
}