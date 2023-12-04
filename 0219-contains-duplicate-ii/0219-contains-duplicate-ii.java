class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Approach - 1
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int i = 0; i < nums.length; ++i) {
//             if (map.containsKey(nums[i])) {
//                 Integer value = map.get(nums[i]);
//                 if (Math.abs(value.intValue() - i) <= k) {
//                     return true;
//                 }
//             }
//             map.put(nums[i], i);
//         }
        
//         return false;
        
        // if i and j are both of same indices
        if (k == 0) {
            return false;
        }
        
        Set<Integer> slidingWindowHash = new HashSet<>();
        
        for (int index = 0; index < nums.length; ++index) {
            
            if (slidingWindowHash.contains(nums[index])) {
                return true;
            }
            
            if (index >= k) {
                slidingWindowHash.remove(nums[index-k]);
            }
            
            slidingWindowHash.add(nums[index]);
        }
        
        return false;
    }
}