class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = nums[0];
        for (int index = 1; index < nums.length; ++index) {
            answer[index] = answer[index-1] * nums[index];
        }
        answer[nums.length-1] = answer[nums.length-2];
        int product = 1;
        for (int index = nums.length-1; index > 0; --index) {
            answer[index] = answer[index-1] * product;
            product = product * nums[index];
        }
        answer[0] = product;
        return answer;
    }
}