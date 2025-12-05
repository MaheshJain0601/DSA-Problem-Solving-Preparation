class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (N < 3) {
            return result;
        }

        int i = 0, j, k, sum;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        while (i < N) {
            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }

            j = i + 1;
            k = N - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    result.add(new ArrayList<>(temp));
                    temp.clear();
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
            i++;
        }
        return result;
    }
}