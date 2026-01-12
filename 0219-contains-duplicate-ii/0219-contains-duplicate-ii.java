class Solution {
    // Approach - 1
    // TC: O(N)
    // SC: O(N)
    public boolean containsNearbyDuplicateApproach1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; ++index) {
            if (map.containsKey(nums[index])) {
                Integer val = map.get(nums[index]);
                if (Math.abs(val.intValue() - index) <= k) {
                    return true;
                }
            }
            map.put(nums[index], index);
        }
        return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        int index = 0;
        Set<Integer> hash = new HashSet<>();

        while (index < nums.length) {
            if (hash.contains(nums[index])) {
                return true;
            }
            
            if (index >= k) {
                hash.remove(nums[index-k]);
            }
            hash.add(nums[index]);
            index++;
        }
        return false;
    }
}