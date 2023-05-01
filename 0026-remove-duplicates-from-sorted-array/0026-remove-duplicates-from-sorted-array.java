class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int element: nums) {
            if (index == 0 || element > nums[index - 1]) {
                nums[index++] = element;
            }
        }
        return index;
    }
}