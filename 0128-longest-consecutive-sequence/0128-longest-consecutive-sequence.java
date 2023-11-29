class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num: nums) {
            elements.add(num);
        }
        
        int maxValue = 0;
        for (int i = 0; i < nums.length; ++i) {
            elements.remove(nums[i]);
            if (!elements.contains(nums[i]-1)) {
                int count = 1;
                int element = nums[i] + 1;
                while (elements.contains(element)) {
                    count++;
                    element = element + 1;
                }
                
                maxValue = Math.max(maxValue, count);
            }
            elements.add(nums[i]);
        }
        
        return maxValue;
    }
}