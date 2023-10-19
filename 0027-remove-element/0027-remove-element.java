class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            if (nums[start] == val) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                start++;
            }
        }
        
        return start;
    }
}