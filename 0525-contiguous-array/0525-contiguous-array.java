class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int maxLength = 0;
        
        int sum = 0;
        for (int index = 0; index < nums.length; ++index) {
            sum += ((nums[index] == 0)? -1: 1);
            
            if (sum == 0) {
                maxLength = index + 1;
            } else if (prefixSum.containsKey(sum)) {
                maxLength = Math.max(maxLength, index - prefixSum.get(sum));
            } else {
                prefixSum.put(sum, index);
            }
        }
        
        return maxLength;
    }
}