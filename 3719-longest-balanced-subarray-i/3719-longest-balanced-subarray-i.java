class Solution {
    public int longestBalanced(int[] nums) {
        int N = nums.length;

        int maxBalanced = 0;

        Set<Integer> evenNumbers, oddNumbers;

        for (int i = 0; i < N; i++) {
            evenNumbers = new HashSet<>();
            oddNumbers = new HashSet<>();
            for (int j = i; j < N; ++j) {
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