class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        
        int left = 0, right = nums.length - 1;
        for (int rIndex = nums.length-1; rIndex >= 0; --rIndex) {
            if (nums[left]*nums[left] > nums[right]*nums[right]) {
                answer[rIndex] = nums[left]*nums[left];
                left++;
            } else {
                answer[rIndex] = nums[right]*nums[right];
                right--;
            }
        }
        return answer;
      
    }
}