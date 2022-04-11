class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int index = 0; index < nums.length; ++index) {
            int jumpIndex = Math.abs(nums[index]) - 1;
            if (nums[jumpIndex] < 0) {
                answer.add(Math.abs(nums[index]));
            }
            nums[jumpIndex] *= -1;
        }
        return answer;
    }
}