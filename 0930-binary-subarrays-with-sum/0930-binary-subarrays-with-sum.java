class Solution {
    public int numSubarraysWithSumAlongWithSpace(int[] nums, int goal) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - goal)) {
                result += preSum.get(sum - goal);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
    
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int goal) {
        int result = 0;    
        int left = 0, right = 0;
        int currSum = 0;
        
        while (right < nums.length) {
            currSum += nums[right];
            while (left <= right && currSum > goal) {
                currSum -= nums[left];
                left++;
            }
            result += (right - left + 1);
            right++;
        }
        return result;
    }
}