class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countOnes = 0;
        int maxCountOnes = 0;
        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] == 0) {
                maxCountOnes = Math.max(maxCountOnes, countOnes);
                countOnes = 0;
                continue;
            } 
            countOnes++;
        }
        maxCountOnes = Math.max(maxCountOnes, countOnes);
        return maxCountOnes;
    }
}