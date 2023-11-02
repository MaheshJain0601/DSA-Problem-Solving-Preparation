class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int lastElement = nums[index-1];
        int lastElementFrequency = 1;
        
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] > lastElement) {
                lastElement = nums[j];
                lastElementFrequency = 1;
                nums[index] = lastElement;
                index++;
            } else if (nums[j] == lastElement && lastElementFrequency < 2) {
                nums[index] = lastElement;
                lastElementFrequency++;
                index++;
            }
        }
        
        return index;
    }
}