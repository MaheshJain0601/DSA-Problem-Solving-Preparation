class Solution {
    public int longestSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;

        int resultXor = 0;
        boolean allZeroes = true;

        for (int num: nums) {
            if (allZeroes && num != 0) {
                allZeroes = false;
            }
            resultXor = resultXor ^ num;
        }
        if (allZeroes) {
            return 0;
        } 
        return resultXor == 0 ? N - 1 : N;
    }
}