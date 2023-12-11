class NumArray {
    
    int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        
        prefixSum = new int[nums.length];
        populatePrefixSum(nums);
    }
    
    private void populatePrefixSum(int[] nums) {
        prefixSum[0] = nums[0];
        
        for (int index = 1; index < nums.length; ++index) {
            prefixSum[index] = prefixSum[index-1] + nums[index];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left - 1 < 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left -1];
        
    }
}
// [-2, -2, 1, -4, -2, -3]

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */