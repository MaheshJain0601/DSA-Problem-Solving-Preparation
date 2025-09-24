class Solution {
    private int getNumSplitsWithMaxSumAsX(int[] nums, int N, int k, int X) {
        if (k > N) {
            return -1;
        }

        int currSum = 0;
        int totalSplits = 1;

        for (int index = 0; index < N; ++index) {
            if (currSum + nums[index] <= X) {
                currSum = currSum + nums[index];
            } else {
                totalSplits += 1;
                currSum = nums[index];
            }
        }
        return totalSplits;
    }
    public int splitArray(int[] nums, int k) {
        int N = nums.length;
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        int mid;

        while (low <= high) {
            mid = low + (high-low)/2;

            if (getNumSplitsWithMaxSumAsX(nums, N, k, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}