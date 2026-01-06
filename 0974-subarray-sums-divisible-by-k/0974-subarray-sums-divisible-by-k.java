class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        int totalSubarrays = 0;
        int currSum = 0, rem;

        // For the entire array to be considered
        remainderCount.put(currSum%k, 1);

        for (int index = 0; index < nums.length; ++index) {
            currSum += nums[index];
            rem = currSum % k;
            // Never store negative remainder, because it loose the previously found element
            // Let say, = 7 * N - 4(remainder)
            //          = 7 * N - 4 + 7 - 7
            //          = 7 (N - 1) + 3
            if (rem < 0) {
                rem += k;
            }
            
            if (remainderCount.containsKey(rem)) {
                totalSubarrays += remainderCount.get(rem);
            }
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        return totalSubarrays;
    }
}