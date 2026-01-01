class Solution {
    // Approach - 1: Brute Force
    // TC: O(N^2)
    // SC: O(1)
    public int maxWidthRampApproach1(int[] nums) {
        int ramp = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] <= nums[j]) {
                    ramp = Math.max(ramp, j - i);
                }
            }
        }
        return ramp;
    }

    // Approach - 2: Slightly better (than brute)
    // TC: O(N^2)
    // SC: O(1)
    public int maxWidthRampApproach2(int[] nums) {
        int ramp = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = nums.length - 1; j > i; --j) {
                if (nums[i] <= nums[j]) {
                    ramp = Math.max(ramp, j - i);
                    break;
                }
            }
        }
        return ramp;
    }

    // Approach - 3: Optimal
    // TC: O(N^2)
    // SC: O(1)
    public int maxWidthRamp(int[] nums) {
        int ramp = 0, N = nums.length;
        int[] rightMax = new int[N];
        
        rightMax[N-1] = nums[N-1];
        for (int i = N - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int i = 0, j = 0;
        while (j < N) {
            while (i < j && nums[i] > rightMax[j]) { // Does not follows nums[i] <= nums[j]
                i++;
            }

            ramp = Math.max(ramp, j - i);
            j++;
        }
        return ramp;
    }
}