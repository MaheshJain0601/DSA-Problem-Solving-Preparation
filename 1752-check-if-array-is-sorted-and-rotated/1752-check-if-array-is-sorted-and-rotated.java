class Solution {
    public boolean check(int[] nums) {
        int N = nums.length;
        int count = 0;
        for (int index = 1; index < N; ++index) {
            if (nums[index-1] > nums[index]) {
                count++;
            }
        }
        if (nums[N - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }
}