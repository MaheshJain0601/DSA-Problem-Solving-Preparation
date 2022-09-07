class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for (int index = 1; index < nums.length; ++index) {
            if (nums[index-1] > nums[index]) {
                count++;
            }
        }
        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }
        return (count <= 1);
    }
}