class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int index = 0; index < nums1.length; ++index) {
            if (freq.containsKey(nums1[index])) {
                int value = freq.get(nums1[index]);
                freq.put(nums1[index], ++value);
            } else {
                freq.put(nums1[index], 1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nums2.length; ++index) {
            if (freq.containsKey(nums2[index]) && freq.get(nums2[index]) > 0) {
                result.add(nums2[index]);
                int value = freq.get(nums2[index]);
                freq.put(nums2[index], --value);
            }
        }        
        return result.stream().mapToInt(i -> i).toArray();
        
    }
}