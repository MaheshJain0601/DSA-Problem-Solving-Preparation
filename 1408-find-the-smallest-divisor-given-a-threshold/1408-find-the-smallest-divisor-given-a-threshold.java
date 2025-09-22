class Solution {
    private int getSumOfDivisors(int[] nums, int dividend) {
        int N = nums.length;

        int sumOfDivisors = 0;
        for (int index = 0; index < N; ++index) {
            sumOfDivisors += Math.ceil(nums[index]/(dividend*1.0));
        }

        return sumOfDivisors;
    }
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        int mid, result = Integer.MAX_VALUE;

        while (low <= high) {
            mid = low + (high - low)/2;

            int sumOfDivisors = getSumOfDivisors(nums, mid);
            if (sumOfDivisors <= threshold) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}