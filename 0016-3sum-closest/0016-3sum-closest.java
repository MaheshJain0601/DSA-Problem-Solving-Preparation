class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        if ( N < 3) {
            return 0;
        }

        int closestSum = Integer.MAX_VALUE;

        int i = 0, j, k, sum;
        Arrays.sort(nums);
        while (i <= N - 3) {
            j = i + 1;
            k = N - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) j++;
                else k--;
            }
            i++;
        }
        return closestSum;
    }
}