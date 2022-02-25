class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                element = num;
            }
            if (num == element) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return element;
        
    }
}