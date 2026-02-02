class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOnes = 0;
        int maxCountOnes = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                countOnes = 0;
            } else {
                countOnes += 1;
            }
            maxCountOnes = Math.max(maxCountOnes, countOnes);
            index++;
        }
        return maxCountOnes;
    }
}