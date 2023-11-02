class Solution {
    public int majorityElement(int[] nums) {
        int index = 0;
        int majorityElement = nums[index];
        int frequency = 1;
        
        for (index = 1; index < nums.length; ++index) {
            if (frequency == 0) {
                majorityElement = nums[index];
                frequency = 1;
                continue;
            }
            
            if (majorityElement == nums[index]) {
                frequency++;
            } else {
                frequency--;
            }
        }
        return majorityElement;
    }
}