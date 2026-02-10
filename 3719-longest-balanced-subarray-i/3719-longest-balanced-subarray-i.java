class Solution {
    public int longestBalanced(int[] nums) {
        int maxBalanced = 0;

        Set<Integer> evenNumbers, oddNumbers;

        for (int i = 0; i < nums.length; i++) {
            evenNumbers = new HashSet<>();
            oddNumbers = new HashSet<>();
            for (int j = i; j < nums.length; ++j) {
                if (nums[j] % 2 == 0) {
                    evenNumbers.add(nums[j]);
                } else {
                    oddNumbers.add(nums[j]);
                }

                if (evenNumbers.size() == oddNumbers.size()) {
                    maxBalanced = Math.max(maxBalanced, j - i + 1);
                }
            }
        }
        return maxBalanced;
    }
}