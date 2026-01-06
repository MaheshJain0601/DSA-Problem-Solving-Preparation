class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int prefixSum = 0;
        preSum.put(0, 1);
        int totalSubarrays = 0;
        for (int index = 0; index < nums.length; ++index) {
            prefixSum += nums[index];
            if (preSum.containsKey(prefixSum - k)) {
                totalSubarrays += preSum.get(prefixSum - k);
            }
            preSum.put(prefixSum, preSum.getOrDefault(prefixSum, 0) + 1);
        }
        return totalSubarrays;
    }
}